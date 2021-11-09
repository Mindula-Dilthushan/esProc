package com.raqsoft.expression.mfn.dw;

import java.io.File;
import java.io.IOException;
import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.dm.DataStruct;
import com.raqsoft.dm.FileObject;
import com.raqsoft.dm.Sequence;
import com.raqsoft.dm.cursor.ICursor;
import com.raqsoft.dm.cursor.MemoryCursor;
import com.raqsoft.dw.Cuboid;
import com.raqsoft.dw.ITableMetaData;
import com.raqsoft.dw.TableMetaData;
import com.raqsoft.dw.TableMetaDataGroup;
import com.raqsoft.expression.Expression;
import com.raqsoft.expression.IParam;
import com.raqsoft.expression.ParamInfo2;
import com.raqsoft.expression.TableMetaDataFunction;
import com.raqsoft.resources.EngineMessage;

/**
 * 为组表生成预汇总立方体
 * T.cuboid(C,Fi,…;y:Gi,…)
 * @author RunQian
 *
 */
public class CreateCuboid extends TableMetaDataFunction {
	public Object calculate(Context ctx) {
		if (table instanceof TableMetaDataGroup) {
			ITableMetaData[] tables = ((TableMetaDataGroup)table).getTables();
			for (ITableMetaData t : tables) {
				createCuboid((TableMetaData) t, param, ctx);
			}
			return table;
		} else {
			TableMetaData srcTable = (TableMetaData)table;
			/*TableMetaData tmd = srcTable.getSupplementTable(false);
			
			if (tmd != null) {
				createCuboid(tmd, param, ctx);
			}*/
			return createCuboid(srcTable, param, ctx);
		}
	
	}
	
	private static Object createCuboid(TableMetaData srcTable, IParam param,  Context ctx) {
		String C;
		if (param == null) {
			try {
				return srcTable.deleteCuboid(null);
			} catch (IOException e) {
				throw new RQException(e.getMessage(), e);
			}
		} else if (param.isLeaf()) {
			C = (String) param.getLeafExpression().getIdentifierName();
			//delete
			try {
				return srcTable.deleteCuboid(C);
			} catch (IOException e) {
				throw new RQException(e.getMessage(), e);
			}
		}
		
		IParam sub0;
		IParam sub1 = null;
		if (param.getType() == IParam.Semicolon) {
			int size = param.getSubSize();
			if (size > 2) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("cuboid" + mm.getMessage("function.invalidParam"));
			}
			
			sub0 = param.getSub(0);
			if (sub0 == null) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("cuboid" + mm.getMessage("function.invalidParam"));
			}
			
			sub1 = param.getSub(1);
		} else {
			sub0 = param;
		}
		
		C = (String) sub0.getSub(0).getLeafExpression().getIdentifierName();
		sub0 = sub0.create(1, sub0.getSubSize());
		
		Expression []exps;
		String []names = null;
		Expression []newExps = null;
		String []newNames = null;
		ParamInfo2 pi0 = ParamInfo2.parse(sub0, "cuboid", true, false);
		exps = pi0.getExpressions1();
		names = new String[exps.length];
		int i = 0;
		for(Expression e : exps) {
			String s = e.getIdentifierName();
			names[i++] = s;
		}
		
		ParamInfo2 pi1 = null;
		if (sub1 != null) {
			pi1 = ParamInfo2.parse(sub1, "cuboid", true, false);
			newExps = pi1.getExpressions1();
			newNames = new String[newExps.length];
			i = 0;
			for(Expression e : newExps) {
				String s = e.getIdentifierName();
				newNames[i++] = s;
			}
		}
		
		//为cuboid命名
		String dir = srcTable.getGroupTable().getFile().getAbsolutePath() + "_";
		FileObject fo = new FileObject(dir + srcTable.getTableName() + Cuboid.CUBE_PREFIX + C);
		if (fo.isExists())
		{
			fo.delete();
		}
		
		String cuboids[] = srcTable.getCuboids();
		if (cuboids != null) {
			for (String c : cuboids) {
				if(C.equals(c)) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("cuboid" + mm.getMessage("dw.cuboidAlreadyExist"));
				}
			}
		}
		
		int fcount = exps == null ? 0 : exps.length;
		if (newExps != null) fcount += newExps.length;
		ICursor cursor = new MemoryCursor(Cuboid.cgroups(sub0, sub1, srcTable, null, false, 0, null, ctx));
		
		//保存到另一个组表
		File file = fo.getLocalFile().file();
		String colNames[] = new String[fcount];
		int sbytes[] = new int[fcount];
		i = 0;
		for(String n : names) {
			colNames[i++] = "#" + n;
		}
		
		for(String s : newNames) {
			colNames[i++] = s;
		}
		Cuboid table = null;
		try {
			table = new Cuboid(file, colNames, sbytes, ctx, "cuboid", "cuboid",
					pi0.getExpressionStrs1(), pi1.getExpressionStrs1());
			table.save();
			table.close();
			table = new Cuboid(file, ctx);//重新打开
			table.checkPassword("cuboid");
			
			Sequence data = cursor.peek(1);		
			if (data == null || data.length() <= 0) {
				return srcTable;
			}
			DataStruct ds = data.dataStruct();
			String fnames[] = ds.getFieldNames();
			System.arraycopy(colNames, 0, fnames, 0,  fcount);
			System.arraycopy(names, 0, fnames, 0,  names.length);
			
			table.append(cursor);
			table.setSrcCount(srcTable.getActualRecordCount());
			table.writeHeader();
			table.close();
			srcTable.addCuboid(C);
		} catch (Exception e) {
			if (table != null) table.close();
			file.delete();
			throw new RQException(e.getMessage(), e);
		}
		return srcTable;
	}
}
