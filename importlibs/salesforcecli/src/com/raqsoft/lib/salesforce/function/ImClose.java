package com.raqsoft.lib.salesforce.function;

import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.expression.Node;
import com.raqsoft.resources.EngineMessage;

// 关闭连接.
public class ImClose extends ImFunction {
	public Node optimize(Context ctx) {
		return this;
	}

	public Object calculate(Context ctx) {
		if (param == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("sf_close " + mm.getMessage("function.missingParam"));
		}

		Object o = param.getLeafExpression().calculate(ctx);
		if ((o instanceof ImOpen)) {
			ImOpen cls = (ImOpen)o;
			cls.m_httpPost.releaseConnection();
		}else{
			MessageManager mm = EngineMessage.get();
			throw new RQException("sf_close " + mm.getMessage("HttpPost releaseConnection false"));
		}
		
		return null;
	}
}
