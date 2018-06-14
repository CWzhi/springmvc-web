package cn.shihua.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.shihua.ssm.pojo.Items;
import cn.shihua.ssm.service.ItemService;
import cn.shihua.ssm.vo.QueryVO;

@Controller
//@RequestMapping("/ItemController")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping( value="/queryItemsList.action")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public ModelAndView queryItemsList(){
		 
		
		//int i =1/0;
		List<Items> queryItemList = itemService.queryItemList();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemList",queryItemList);
		modelAndView.setViewName("itemList");
		
		return modelAndView;
	}
	@RequestMapping("/queryitem.action")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public String  queryItem(HttpServletRequest  request,HttpServletResponse response) throws IOException{
		
		
		
		
		return "item";	
	}
	@RequestMapping(value="/updateitems.action")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public String updateitems(QueryVO vo ){
		
		List<Items> itemsList = vo.getItemList();
		System.out.println(itemsList);
		
		
		
		return "success";
	}
	//接收上传的图片
	@RequestMapping(value="/updateitem.action")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public String updateitem(QueryVO vo,MultipartFile pictureFile ) throws IllegalStateException, IOException{
											//这是个上传文件接口的名字,一定和jsp中的<input type="file"  name="pictureFile"/> name名字一样.
																		//可以变,用@RequestParam这个注解,可以变参数名称
											//这是个接口,得需要实现类.并需要spring容器管理
		//图片通过这个解析器来保存到这个解析器中了,通过这个解析器可以拿到图片
		
		//从pictureFile这个对象中获取图片保存到D:\\upload
		String pitName = UUID.randomUUID().toString().replaceAll("-", "");//防止重名
		System.out.println(pitName);
		
		//获取文件原名(文件名+后缀名)
		String originalFilename = pictureFile.getOriginalFilename();
		//获取文件后缀
		//String extension = FilenameUtils.getExtension(originalFilename);//这是文件上传jar包的工具类
		String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		//上传这个文件到哪,并重命名
				pictureFile.transferTo(new File("D:\\upload\\"+pitName+"."+extension)); //直接保存到指定的地点.
		vo.getItems().setPic(pitName+"."+extension);//数据库保存的是名字.文件名

	/*	List<Items> itemsList = vo.getItemList();
		System.out.println(itemsList);*/
		
		// 更新商品
		this.itemService.updateItemById(vo.getItems());
		
		return "redirect:/editItem.action?id="+vo.getItems().getId();
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
	@RequestMapping(value="/itemEdit")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public String queryItemById(HttpServletRequest request,Model model){
		
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		//Integer id = Integer.valueOf(ids);
		Items item = itemService.queryItemById(id);
		
		/*ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("item",item);
		modelAndView.setViewName("itemList");*/
		
		model.addAttribute("item",item);
		
		return "editItem";
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
