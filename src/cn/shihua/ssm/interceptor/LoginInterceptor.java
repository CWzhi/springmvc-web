package cn.shihua.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//自定义拦截处理器的拦截器   实现接口
public class LoginInterceptor implements HandlerInterceptor {

	//拦截之前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("访问controller方法之前1");
		/*方法前有个开关,
		 	登录--->放行返回true
		 	未登录--->不放行返回false
		 * */
		
		// 从request中获取session
		HttpSession session = request.getSession();
		
		//设置session的有效时间(存储时间)
		session.setMaxInactiveInterval(5);//5秒，注意服务器端的3600秒，而不是客户端的
		// 从session中获取username
		Object username = session.getAttribute("username");
		//判断用户是否登录,如果登录就放行返回true
					//如果没有登录就重定向到登录页面进行登录  并返回false
		//URI:   /login.action
		//URL: 	 http://localhost:8080/springmvc-web/login.action
		String requestURI = request.getRequestURI();
		/*if(requestURI.contains("/login")){
			return true;//放行
		}*/
		if(!requestURI.contains("/login")){//路径不包含login则需要判断，
			//要是包含login则放行
			String username1 = (String) request.getSession().getAttribute("username");
			if (username1==null){
				response.sendRedirect(request.getContextPath()+"/user/toLogin.action");
				return false;
				
			}
			
		}
		//return true; 
		// 判断username是否为null
		if (username != null) {
			// 如果不为空则放行
			return true;
		} else {
			// 如果为空则跳转到登录页面
			System.out.println(request.getContextPath());//   /springmvc-web  打印出的项目的根路径  即访问web服务的	Context root  即项目名 
			response.sendRedirect(request.getContextPath() + "/user/toLogin.action");
		}
		
		return false;//拦截器已经拒绝访问
	}
	//拦截之后
		public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
				throws Exception {
			System.out.println("访问controller方法之后1");
		}
	//渲染之后
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("页面渲染后1");
		
	}


}
