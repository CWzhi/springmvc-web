package cn.shihua.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";//返回到登录页面
	}
	

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("login")//进入到登录页面登录
	public String login(String username, String password, HttpSession session) {
		// 校验用户登录
		System.out.println(username);
		System.out.println(password);

		// 把用户名放到session中
		session.setAttribute("username", username);

		return "redirect:/item/queryItemsList.action";
	}
	
	
}
