package cn.shihua.ssm.controller;

import java.util.ArrayList;
import java.util.List;

public class Tongpeifu {
	
	public static void main(String[] args) throws Exception {
		
		
		List<Number> numList = new ArrayList<Number>();
		List<Integer> intList = new ArrayList<Integer>();
		numList.addAll(intList);//正确！！！！！！addAll(Collection<? extends Number> c), 传递的是List<Integer>
		throw new  Exception("xiaoming");
		
		//System.out.println(numList);
	}

}
