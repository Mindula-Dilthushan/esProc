package com.raqsoft.expression.mfn.table;

import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.expression.IParam;
import com.raqsoft.expression.TableFunction;
import com.raqsoft.resources.EngineMessage;

/**
 * �������������
 * T.keys(Ki,��)
 * @author RunQian
 *
 */
public class Keys extends TableFunction {
	public Object calculate(Context ctx) {
		if (param == null) {
			srcTable.setPrimary(null);
		} else if (param.getType() == IParam.Semicolon) {
			IParam sub1 = param.getSub(1);
			if (sub1 == null) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("keys" + mm.getMessage("function.invalidParam"));
			}
			
			Object obj = sub1.getLeafExpression().calculate(ctx);
			if (!(obj instanceof Number)) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("keys" + mm.getMessage("function.paramTypeError"));
			}

			int capacity = ((Number)obj).intValue();
			if (capacity < 1) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("keys" + mm.getMessage("function.invalidParam"));
			}
			
			param = param.getSub(0);
			if (param == null) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("keys" + mm.getMessage("function.invalidParam"));
			}
			
			String []cols;
			if (param.isLeaf()) {
				cols = new String[]{param.getLeafExpression().getIdentifierName()};
			} else {
				int size = param.getSubSize();
				cols = new String[size];
				for (int i = 0; i < size; ++i) {
					IParam sub = param.getSub(i);
					if (sub == null) {
						MessageManager mm = EngineMessage.get();
						throw new RQException("keys" + mm.getMessage("function.invalidParam"));
					}
					
					cols[i] = sub.getLeafExpression().getIdentifierName();
				}
			}
			
			srcTable.setPrimary(cols);
			srcTable.createIndexTable(capacity, option);
		} else {
			String []cols;
			if (param.isLeaf()) {
				cols = new String[]{param.getLeafExpression().getIdentifierName()};
			} else {
				int size = param.getSubSize();
				cols = new String[size];
				for (int i = 0; i < size; ++i) {
					IParam sub = param.getSub(i);
					if (sub == null) {
						MessageManager mm = EngineMessage.get();
						throw new RQException("keys" + mm.getMessage("function.invalidParam"));
					}
					
					cols[i] = sub.getLeafExpression().getIdentifierName();
				}
			}
			
			srcTable.setPrimary(cols);
			if (option != null && option.indexOf('i') != -1) {
				srcTable.createIndexTable(option);
			}
		}
		
		return srcTable;
	}
}
