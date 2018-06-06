package cn.shihua.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.shihua.ssm.pojo.Items;
import cn.shihua.ssm.service.ItemService;

@Controller
//@RequestMapping("/ItemController")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/queryItemsList")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public ModelAndView queryItemsList(){
		
		List<Items> queryItemList = itemService.queryItemList();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemList",queryItemList);
		modelAndView.setViewName("itemList");
		
		
		return modelAndView;
	}
	
	@RequestMapping("/itemEdit1")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public ModelAndView queryItemById1(HttpServletRequest request){
		
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		//Integer id = Integer.valueOf(ids);
		Items Item = itemService.queryItemById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("item",Item);
		modelAndView.setViewName("itemList");
		
		
		return modelAndView;
	}
	@RequestMapping("/itemEdit")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public String queryItemById(HttpServletRequest request,Model model){
		
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		//Integer id = Integer.valueOf(ids);
		Items item = itemService.queryItemById(id);
		
		/*ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("item",item);
		modelAndView.setViewName("itemList");*/
		
		model.addAttribute("item",item);
		
		return "item";
	}
	@RequestMapping("/updateItem")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public String updateItemById(HttpServletRequest request,@ModelAttribute("item")Items item,Model model ){
														///*@ModelAttribute("item")*/这个注解有无都可
		//String ids = request.getParameter("id");
		//int id = Integer.parseInt(ids);
		//Integer id = Integer.valueOf(ids);
		
		
		int i = itemService.updateItemById(item);
		
		/*ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("item",item);
		modelAndView.setViewName("itemList"updateItemById);*/
		
		model.addAttribute("insert",i);
		
		return "update";
	}

}
