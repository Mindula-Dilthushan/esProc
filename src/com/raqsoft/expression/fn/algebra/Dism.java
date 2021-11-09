package com.raqsoft.expression.fn.algebra;

import com.raqsoft.common.Logger;
import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.dm.Sequence;
import com.raqsoft.expression.Function;
import com.raqsoft.expression.IParam;
import com.raqsoft.resources.EngineMessage;

/**
 * 两个向量之间的马氏距离dism(A, B)
 * @author bd
 */
public class Dism extends Function {
	public Object calculate(Context ctx) {
		if (param == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("dism" + mm.getMessage("function.missingParam"));
		} else if (param.isLeaf()) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("dism" + mm.getMessage("function.invalidParam"));
		} else {
			if (param.getSubSize() < 2) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("dism" + mm.getMessage("function.invalidParam"));
			}

			IParam sub1 = param.getSub(0);
			IParam sub2 = param.getSub(1);
			IParam sub3 = null;
			if (param.getSubSize() > 2) {
				sub3 = param.getSub(2);
			}
			if (sub1 == null || sub2 == null) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("dism" + mm.getMessage("function.invalidParam"));
			}
			Object o1 = sub1.getLeafExpression().calculate(ctx);
			Object o2 = sub2.getLeafExpression().calculate(ctx);
			Object o3 = null;
			if (sub3 != null) {
				o3 = sub3.getLeafExpression().calculate(ctx);
			}
			if (o1 instanceof Sequence && o2 instanceof Sequence) {
				Matrix A = new Matrix((Sequence) o1);
				Matrix B = new Matrix((Sequence) o2);
				Matrix S = null;
				if (o3 instanceof Sequence) {
					S =  new Matrix((Sequence) o3);
				}
				if (A.getCols() == 0 || A.getRows() != 1) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("dism" + mm.getMessage("function.paramTypeError"));
				}
				else if (B.getCols() == 0 ||B.getRows() != 1) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("dism" + mm.getMessage("function.paramTypeError"));
				}
				
				double[] as = A.getArray()[0];
				double[] bs = B.getArray()[0];
				int rs = as.length;
				if (rs != bs.length) {
					// 不同维
					MessageManager mm = EngineMessage.get();
					Logger.warn("dism" + mm.getMessage("function.paramTypeError"));
					return 0;
				}
				Matrix X = new Matrix(2, rs);
				double[][] xs = X.getArray();
				xs[0] = as;
				xs[1] = bs;
				if (S == null) {
					S = X.covm();
				}
				Matrix SI = null;
				try {
					SI = S.inverse();
				}
				catch (Exception e) {
					// S无法求逆时，求伪逆矩阵
					SI = S.pseudoinverse();
				}
				Matrix D = new Matrix(rs, 1);
				double[][] ds = D.getArray();
				for (int i = 0; i < rs; i++) {
					ds[i][0] = as[i] - bs[i];
				}
				Matrix DT = D.transpose();
				Matrix res = DT.times(SI);
				res = res.times(D);
				if (res.getCols() == 1 && res.getRows() == 1) {
					double r = res.get(0, 0);
					return Math.sqrt(r);
				}
				return 0;
			} else {
				MessageManager mm = EngineMessage.get();
				throw new RQException("dism" + mm.getMessage("function.paramTypeError"));
			}
		}
	}
}
