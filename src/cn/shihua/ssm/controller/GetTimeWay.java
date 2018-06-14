package cn.shihua.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;

public class GetTimeWay {
	
	public static void main(String[] args) {
		
		//获取当前系统时间
		Date date = new Date();
		System.out.println("当前系统时间"+date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(date);
		System.out.println(format);
		
		//java获取系统/服务器时间方法：
		String date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(date1);
		System.out.println(Calendar.getInstance().getTime());
		
		
	}
	  @Test
	public void ceshi() throws ParseException{
		
		  GetNowDate getNowDate = new GetNowDate();
		  System.out.println(getNowDate.getYMD());
		  System.out.println(getNowDate.getHMS());
		  String source ="2015-01-01 24:01:38";
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这是字符串的格式
			Date date = sdf.parse(source);//用sdf对象将这个字符串日期的格式转换成Date类型的日期
			System.out.println("date:"+date);
		String format = sdf.format(date);//将日期类型的数据转换成字符串
		System.out.println("format:"+format);
	}
	  @Test
	  public void ceshisss(){
		  String pitName = UUID.randomUUID().toString();//防止重名
			
			System.out.println(pitName);
	  }
	  
	 


}