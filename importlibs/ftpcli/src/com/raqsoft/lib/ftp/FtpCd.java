package com.raqsoft.lib.ftp;

import java.util.ArrayList;

import com.raqsoft.common.Logger;
import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.expression.Function;
import com.raqsoft.expression.IParam;
import com.raqsoft.expression.Node;
import com.raqsoft.resources.EngineMessage;

public class FtpCd  extends Function {

	public Node optimize(Context ctx) {
		if (param != null) {
			param.optimize(ctx);
		}
		return this;
	}

	public Object calculate(Context ctx) {
		if (param == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("ftp_cd" + mm.getMessage("function.missingParam"));
		}

		int size = param.getSubSize();
//		if (size != 2) {
//			MessageManager mm = EngineMessage.get();
//			throw new RQException("ftp_cd" + mm.getMessage("function.invalidParam"));
//		}
		
		
		FtpClientImpl client = null;
		SFtpClientImpl sclient = null;
		String path = null;
		if (size == 0) {
			Object o = param.getLeafExpression().calculate(ctx);
			if (o instanceof FtpClientImpl) client = (FtpClientImpl)o;
			else if (o instanceof SFtpClientImpl) sclient = (SFtpClientImpl)o;
			else throw new RQException("first parameter is not ftp_client");
			path = "/";
		} else {
			for(int i=0; i<size; i++){
				if (param.getSub(i) == null ) {
					MessageManager mm = EngineMessage.get();
					throw new RQException("ftp_cd" + mm.getMessage("function.invalidParam"));
				}
				
				if (i==0) {
					Object o = param.getSub(i).getLeafExpression().calculate(ctx);
					if (o instanceof FtpClientImpl) client = (FtpClientImpl)o;
					else if (o instanceof SFtpClientImpl) sclient = (SFtpClientImpl)o;
					else throw new RQException("first parameter is not ftp_client");
				} else if (i == 1) {
					path = (String)param.getSub(i).getLeafExpression().calculate(ctx);
				}
			}
		}
		
		boolean r = false;
		try {
			if (client != null) r = client.changeRemoteDir(path);
			else r = sclient.changeRemoteDir(path);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RQException("ftp_cd : " + e.getMessage());
		}
		return "change directory ["+path+"] " + (r?"success":"falied");
	}

}
