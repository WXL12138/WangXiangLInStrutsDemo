package com.wxl.interceptor;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		String loginName = "";
		Cookie[] cArr = ServletActionContext.getRequest().getCookies();
		if(cArr!=null){
			for(Cookie c:cArr){
				if("LOGINNAME".equals(c.getName())){
					loginName = c.getValue();
				}
			}
		}
		if("".equals(loginName)){
			return "login";
		}else{
			return arg0.invoke();
		}
	}

}
