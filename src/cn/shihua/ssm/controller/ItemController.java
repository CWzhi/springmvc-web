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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.shihua.ssm.pojo.Items;
import cn.shihua.ssm.service.ItemService;
import cn.shihua.ssm.vo.QueryVO;

@Controller
@RequestMapping("/item")//只让拦截器拦截商品---->只拦截item路径下的url
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping( value="/queryItemsList.action")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	@ResponseBody()
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
		String extension=null;
		boolean b1=originalFilename==null;
		System.out.println("b1:"+b1);
		boolean b2=originalFilename.isEmpty();
		System.out.println("b2:"+b2);
		boolean b3=originalFilename.length()==0;
		System.out.println("b3:"+b3);
		boolean b4=!originalFilename.equals("");
		System.out.println("b4:"+b4);
		System.out.println("originalFilename:"+originalFilename);
		if(originalFilename!=null&&!originalFilename.isEmpty()&&originalFilename.length()!=0&&!originalFilename.equals("")){
		//extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			//获取文件后缀
			extension = FilenameUtils.getExtension(originalFilename);
		}else{
		//若用户没有选择新图片,则不改变原来的,直接获取原来的图片上传存入即可
			//根据ID获取原来的图片名
			Items item=itemService.queryItemById(vo.getItems().getId());
			pitName=item.getPic();
		}
		//上传这个文件到哪,并重命名
		if(originalFilename!=null&&!originalFilename.isEmpty()&&originalFilename.length()!=0&&!originalFilename.equals("")){
			//extension = originalFilename.substring(originalFilename.lastIndexOf("."));
				//获取文件后缀
				//extension = FilenameUtils.getExtension(originalFilename);
			//如果用户没有再次重新选择一个新的图片,则不用再次上传,因为这个图片已经上传过了
				pictureFile.transferTo(new File("D:\\upload\\"+pitName+"."+extension)); //直接保存到指定的地点.
				vo.getItems().setPic(pitName+"."+extension);
			}else{
				
				vo.getItems().setPic(pitName);//数据库保存的是名字.文件名
			}

	/*	List<Items> itemsList = vo.getItemList();
		System.out.println(itemsList);*/
		
		// 更新商品
		this.itemService.updateItemById(vo.getItems());
		
		return "redirect:/itemEdit.action?id="+vo.getItems().getId();
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
	//json数据交互
	//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	//@RequestBody将前端传过来的json格式的字符串转成json,并将值转成对象,要想映射成功的话前提是将json字符串中的k和对象的属性相一致
	//@RequestBody这个注解将json串中的值一一映射到对象中的属性中去
				//这个注解能解析json类型的字符串,
	//这个注解执行解析json时将值放到对应的属性中去的时候,需要导入包
	@RequestMapping("/json")
	//@ResponseBody()
	public @ResponseBody() Items json(@RequestBody Items item ){//pojo来接收
		//@RequestBody将json字符串转成对象.依次映射
		//这个注解调用底层的程序,就是调用springmvc接收json转对象的三个包
		 
		  
		System.out.println(item);	
		 
		//将对象返回去的时候,返回的是json串,
		//怎们将这个对象转成json串呢? 用的是@ResposeBody()注解   
		//虽然返回的是对象,但是这个对象通过@ResponseBody()注解,先将这个对象转成json后返回给前端的
		 return item;
	}
	//restful风格的编程方式
	@RequestMapping(value="/itemEdit/{id}.action")//可以不加action 后缀(web.xml中配置的URL-pattern为*.action)
	public String queryItemByIdRestful(HttpServletRequest request,Model model,@PathVariable Integer id){
																			//@PathVariable 获取请求路径上的变量
		//System.out.println("---------------");
		Items item = itemService.queryItemById(id); 
		
		
		
		/*ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("item",item);
		modelAndView.setViewName("itemList");*/
		
		model.addAttribute("item",item);
		
		return "editItem";
	}
	
	
	


}
