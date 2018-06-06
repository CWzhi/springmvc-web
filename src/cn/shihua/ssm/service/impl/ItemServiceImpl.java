package cn.shihua.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shihua.ssm.mapper.ItemsMapper;
import cn.shihua.ssm.pojo.Items;
import cn.shihua.ssm.pojo.ItemsExample;
import cn.shihua.ssm.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	public List<Items> queryItemList() {
		
		ItemsExample itemsExample = new ItemsExample();
		
		List<Items> list = this.itemsMapper.selectByExample(null);//û��������ѯ->����Ѱ���е���Ŀ
		
		return list;
	}

	@Override
	public Items queryItemById(int id) {
		
		Items selectByPrimaryKey = itemsMapper.selectByPrimaryKey(id);
		
		return selectByPrimaryKey;
	}
	//@Override
	public int updateItemById(Items item) {
		
		int i  = itemsMapper.updateByPrimaryKey(item);
		
		return i ;
	}

}
