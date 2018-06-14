package cn.shihua.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



/**
 * 转换日期类型的数据
 * S:页面传进来的类型
 * T:转换后的类型
 * @author chenweizhi
 *
 * 2018年6月12日
 */
public class DateConverter implements Converter<String, Date> {

	
		@Override
		public Date convert(String source) {
			//转换出异常 返回null
			try {
				// 把字符串转换为日期类型
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这是字符串的格式
				Date date = sdf.parse(source);//用sdf对象将这个字符串日期的格式转换成Date类型的日期
				
				//String format = sdf.format(date);将日期类型的数据转换成字符串

				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 如果转换异常则返回空
			return null;
		}


	}


