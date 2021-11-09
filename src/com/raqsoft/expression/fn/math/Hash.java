package com.raqsoft.expression.fn.math;

import com.raqsoft.expression.IParam;
import com.raqsoft.expression.Function;
import com.raqsoft.dm.Context;
import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.resources.EngineMessage;
import com.raqsoft.util.HashUtil;

/**
 * 求序列成员的hash值或多个参数的hash值
 * @author yanjing
 * hash(xi,…;n)
 */
public class Hash extends Function {
	public Object calculate(Context ctx) {
		IParam param = this.param;
		if (param == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("hash" + mm.getMessage("function.missingParam"));
		}

		HashUtil hashUtil;
		if (param.getType() == IParam.Semicolon) {
			if (param.getSubSize() != 2) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("hash" + mm.getMessage("function.invalidParam"));
			}
			
			IParam sub1 = param.getSub(1);
			if (sub1 == null) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("hash" + mm.getMessage("function.invalidParam"));
			}
			
			Object obj = sub1.getLeafExpression().calculate(ctx);
			if (obj instanceof Number) {
				int n = ((Number)obj).intValue();
				if (n <= 1) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("hash" + mm.getMessage("function.invalidParam"));
				}
				
				hashUtil = new HashUtil(n, false);
			} else if (obj == null) {
				hashUtil = new HashUtil();
			} else {
				MessageManager mm = EngineMessage.get();
				throw new RQException("hash" + mm.getMessage("function.paramTypeError"));
			}
			
			param = param.getSub(0);
			if (param == null) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("hash" + mm.getMessage("function.invalidParam"));
			}
		} else {
			hashUtil = new HashUtil();
		}
		
		if (param.isLeaf()) {
			Object val = param.getLeafExpression().calculate(ctx);
			return new Integer(hashUtil.hashCode(val) + 1);
		} else {
			int size = param.getSubSize();
			Object []vals = new Object[size];
			for (int i = 0; i < size; ++i) {
				IParam sub = param.getSub(i);
				if (sub == null) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("hash" + mm.getMessage("function.invalidParam"));
				}
				
				vals[i] = sub.getLeafExpression().calculate(ctx);
			}

			return new Integer(hashUtil.hashCode(vals, size) + 1);
		}
	}
}
