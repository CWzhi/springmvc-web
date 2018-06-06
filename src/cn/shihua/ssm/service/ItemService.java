package cn.shihua.ssm.service;

import java.util.List;

import cn.shihua.ssm.pojo.Items;

public interface ItemService {

	
	List<Items> queryItemList();

	Items queryItemById(int id);
	
	int updateItemById(Items item);
	
}
