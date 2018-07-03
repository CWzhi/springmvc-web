package cn.shihua.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//自定义拦截处理器的拦截器   实现接口
public class Interceptor1 implements HandlerInterceptor {

	//拦截之前
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("访问controller方法之前1");
		/*方法前有个开关,
		 	登录--->放行返回true
		 	未登录--->不放行返回false
		 * */
		return true;//拦截器已经拒绝访问
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
