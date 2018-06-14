package cn.shihua.ssm.vo;

import java.util.List;

import cn.shihua.ssm.pojo.Items;

public class QueryVO {
	
	private Items items;
	
	private List<Items> itemList;
	



	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	

}
