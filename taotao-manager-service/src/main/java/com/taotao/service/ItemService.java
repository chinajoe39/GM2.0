package com.taotao.service;

import java.util.List;

import com.taotao.pojo.EasyUIListResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	//通过商品id查询到商品
	TbItem getItemById(long itemId);
	
	//获取所有商品
	List<TbItem> getAllItems();
	
	//获取分页的商品
	EasyUIListResult getPagedItems(int page, int rows);
	
}
