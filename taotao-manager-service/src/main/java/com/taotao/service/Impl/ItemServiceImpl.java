package com.taotao.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.EasyUIListResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMappper;
	
	@Override
	public TbItem getItemById(long itemId) {
		//一种写法
		//return itemMappper.selectByPrimaryKey(itemId);
		
		TbItemExample tbItemExample = new TbItemExample();
		Criteria criteria = tbItemExample.createCriteria();
		criteria.andIdEqualTo(itemId);
		
		List<TbItem> tbItemExampleList = itemMappper.selectByExample(tbItemExample);
		if(null != tbItemExampleList && tbItemExampleList.size() > 0){
			return tbItemExampleList.get(0);
		}
		return null;
	}

	@Override
	public List<TbItem> getAllItems() {
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> tbItemExampleList = itemMappper.selectByExample(tbItemExample);
		
		return tbItemExampleList;
	}

	@Override
	public EasyUIListResult getPagedItems(int page, int rows) {
		TbItemExample tbItemExample = new TbItemExample();
		EasyUIListResult result = new EasyUIListResult();
		//分页
		PageHelper.startPage(page, rows);
		List<TbItem> tbItemExampleList = itemMappper.selectByExample(tbItemExample);
		
		PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemExampleList);
		result.setRows(tbItemExampleList);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

}
