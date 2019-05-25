package com.zllg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截进入系统账号管理界面
 * @author Administrator
 *
 */
public class SysInterceptor extends HandlerInterceptorAdapter{
//	日志输出
	private Logger logger = Logger.getLogger(SysInterceptor.class);
//	过滤的url地址
	private static final String[] IGNORE_URI = {"sys","depot","work","finance","personnel",
		  					"money","visitor","customer","login","commont","shop"};

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		
		logger.debug("权限审核");
//		判断是否有权限的标志
		boolean flag = false;
		String redictUrl="/login";
		int index=12;//要访问的权限位置
//		获得地址的url
		String url = request.getRequestURL().toString().substring(27);
		url=url.substring(0,url.indexOf("/"));
		logger.debug("地址为"+url);
//		判断权限
		for(int x=0;x<IGNORE_URI.length;x++){
			if(url.equals(IGNORE_URI[x])){
				index=x;
				break;
			}
		}
//		如果是登录或者公共模块  直接放行
		if(index==8 || index==9){
			logger.debug("用户使用登录或者公共模块，无需验证，直接放行！");
			flag=true;
		}else{
//			判断是否登录，如果未登录跳转登录页面
//			User user = (User)session.getAttribute(Constants.USER_SESSION);
			
			logger.debug("此功能需要登录，用户未登录");
//			如果已登录，则判断权限
			switch(index){
				case 0:break;
				case 1:break;
				case 2:break;
				case 3:break;
				case 4:break;
				case 5:break;
				case 6:break;
				case 7:break;
				case 10:break;
				case 11:break;
				default:break;
			}
		
		}
		
		
		
	
		
//	User user = (User)session.getAttribute(Constants.USER_SESSION);
		
		
		
//		根据结果来决定是否通过
		if(!flag){
			response.sendRedirect(request.getContextPath()+redictUrl);
			logger.debug(request.getContextPath());
			logger.debug("用户无权限访问");
			return false;
		}
		return true;
	}
}
