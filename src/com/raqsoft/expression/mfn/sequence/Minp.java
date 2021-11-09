package com.raqsoft.expression.mfn.sequence;

import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.expression.Expression;
import com.raqsoft.expression.IParam;
import com.raqsoft.expression.SequenceFunction;
import com.raqsoft.resources.EngineMessage;

/**
 * 取使表达式返回值最小的记录
 * A.minp(x)
 * @author RunQian
 *
 */
public class Minp extends SequenceFunction {
	public Object calculate(Context ctx) {
		if (param == null) {
			return srcSequence.minp(null, option, ctx);
		} else if (param.isLeaf()) {
			Expression exp = param.getLeafExpression();
			return srcSequence.minp(exp, option, ctx);
		} else {
			if (param.getSubSize() != 2) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("minp" + mm.getMessage("function.invalidParam"));
			}

			IParam param0 = param.getSub(0);
			IParam param1 = param.getSub(1);
			if (param0 == null || param1 == null) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("minp" + mm.getMessage("function.invalidParam"));
			}

			Expression exp = param0.getLeafExpression();
			Object obj = param1.getLeafExpression().calculate(ctx);
			if (!(obj instanceof Number)) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("minp" + mm.getMessage("function.paramTypeError"));
			}

			int count = ((Number)obj).intValue();
			return srcSequence.minp(exp, count, ctx);
		}
	}
}
