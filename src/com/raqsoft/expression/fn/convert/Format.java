package com.raqsoft.expression.fn.convert;

import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.expression.Function;
import com.raqsoft.expression.IParam;
import com.raqsoft.resources.EngineMessage;

/**
 * 创建格式化的字符串
 * format (s,…) 生成串，…表示s的参数，通过Java格式操作，使任意类型的数据转换成一个字符串。
 * @author runqian
 *
 */
public class Format extends Function {
	public Object calculate(Context ctx) {
		if (param == null || param.isLeaf()) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("format"+mm.getMessage("function.missingParam"));
		}
		
		IParam sub0 = param.getSub(0);
		if (sub0 == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("format" + mm.getMessage("function.invalidParam"));
		}
		
		Object obj = sub0.getLeafExpression().calculate(ctx);
		String fmt;
		if (obj instanceof String) {
			fmt = (String)obj;
		} else if (obj != null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("format" + mm.getMessage("function.paramTypeError"));
		} else {
			return null;
		}
		
		int size = param.getSubSize();
		Object []args = new Object[size - 1];
		for (int i = 1; i < size; ++i) {
			IParam sub = param.getSub(i);
			if (sub != null) {
				args[i - 1] = sub.getLeafExpression().calculate(ctx);
			}
		}
		
		return String.format(fmt, args);
	}
}
