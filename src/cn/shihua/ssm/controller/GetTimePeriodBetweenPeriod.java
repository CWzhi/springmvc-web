package cn.shihua.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class GetTimePeriodBetweenPeriod {
	/**
	 * 获得时间段内连续时间
	 * 
	 * @param mindate
	 *            开始时间
	 * @param maxdate
	 *            结束时间加一天
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getTimeBetweenDay(String mindate, String maxdate) throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		min.setTime(sdf.parse(mindate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), min.get(Calendar.DATE));

		if (maxdate != null && !"".equals(maxdate)) {
			max.setTime(sdf.parse(maxdate));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), max.get(Calendar.DATE));
		}
		Calendar curr = min;
		if (maxdate != null && !"".equals(maxdate)) {
			while (curr.before(max)) {
				result.add(sdf.format(curr.getTime()));
				if(!result.contains(sdf.format(max.getTime()))) {
					result.add(sdf.format(max.getTime()));
				}
				curr.add(Calendar.DAY_OF_MONTH, 1);
			}
		} else {
			result.add(mindate);
		}
		return result;
	}
	
	@Test
	public void test() throws Exception{
		
		List<String> timeBetweenDay = GetTimePeriodBetweenPeriod.getTimeBetweenDay("2015-01-01", "2015-01-31");
		
		String str ="2015-01-01";
		System.err.println(str.substring(0, 7));
		System.out.println(timeBetweenDay.size());
		System.out.println(timeBetweenDay);
	}

	public static List<String> getTimeBetweenMonth(String mindate, String maxdate) throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月
		Calendar min = Calendar.getInstance();// 定义日期实例
		Calendar max = Calendar.getInstance();// 定义日期实例
		Date parse = sdf.parse(mindate);
		min.setTime(sdf.parse(mindate));// 设置日期起始时间
		max.setTime(sdf.parse(maxdate));
		while (min.getTime().before(sdf.parse(maxdate))) {// 判断是否到结束日期
			result.add(sdf.format(min.getTime()));
			if(!result.contains(sdf.format(max.getTime()))) {
				result.add(sdf.format(max.getTime()));
			}
			min.add(Calendar.MONTH, 1);// 进行当前日期月份加1
		}
		return result;
	}

	public static List<String> getTimeBetweenYear(String mindate, String maxdate) throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");// 格式化为年月
		Calendar min = Calendar.getInstance();// 定义日期实例
		Calendar max = Calendar.getInstance();// 定义日期实例
		
		min.setTime(sdf.parse(mindate));// 设置日期起始时间
		max.setTime(sdf.parse(maxdate));
		while (min.getTime().before(sdf.parse(maxdate))) {// 判断是否到结束日期
			result.add(sdf.format(min.getTime()));
			if(!result.contains(sdf.format(max.getTime()))) {
				result.add(sdf.format(max.getTime()));
			}
			min.add(Calendar.YEAR, 1);// 进行当前日期月份加1
		}
		return result;
	}

	/*public static void main(String[] args) throws Exception {
		String s = "2017-01-01";
		String e = "2019-01-10";
		List<String> timeBetweenDay = null;
		//timeBetweenDay = getTimeBetweenMonth(s, e);
		//c = getTimeBetweenDay(s, e);
		timeBetweenDay = getTimeBetweenYear(s, e);
		for (String string : timeBetweenDay) {
			System.out.println(string);
		}
	}*/
}
