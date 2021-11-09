package com.raqsoft.expression.mfn.channel;

import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.expression.ChannelFunction;
import com.raqsoft.expression.Expression;
import com.raqsoft.expression.IParam;
import com.raqsoft.resources.EngineMessage;

/**
 * 为管道定义迭代结果集运算
 * ch.iterate(x,a,c)
 * @author WangXiaoJun
 *
 */
public class Iterate extends ChannelFunction {
	public Object calculate(Context ctx) {
		if (param == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("iterate" + mm.getMessage("function.missingParam"));
		} else if (param.isLeaf()) {
			Expression exp = param.getLeafExpression();
			return channel.iterate(exp, null, null, ctx);
		} else {
			int size = param.getSubSize();
			if (size > 3) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("iterate" + mm.getMessage("function.invalidParam"));
			}

			IParam sub0 = param.getSub(0);
			if (sub0 == null || !sub0.isLeaf()) {
				MessageManager mm = EngineMessage.get();
				throw new RQException("iterate" + mm.getMessage("function.invalidParam"));
			}

			Expression exp = sub0.getLeafExpression();

			Object initVal = null;
			IParam sub1 = param.getSub(1);
			if (sub1 != null) {
				if (!sub1.isLeaf()) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("iterate" + mm.getMessage("function.invalidParam"));
				}

				initVal = sub1.getLeafExpression().calculate(ctx);
			}

			Expression c = null;
			if (size > 2) {
				IParam sub2 = param.getSub(2);
				if (!sub2.isLeaf()) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("iterate" + mm.getMessage("function.invalidParam"));
				}
				
				c = sub2.getLeafExpression();
			}

			return channel.iterate(exp, initVal, c, ctx);
		}
	}
}
