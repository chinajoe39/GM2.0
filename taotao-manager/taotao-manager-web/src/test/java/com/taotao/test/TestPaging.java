package com.taotao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPaging {

	@Test
	public void test(){
		//获取spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-*.xml");
		TbItemMapper mapper = context.getBean(TbItemMapper.class);
		
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1, 10);
		List<TbItem> list = mapper.selectByExample(example);
		
		for (TbItem temp : list) {
			System.out.println(temp.getTitle());
		}

		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("总共商品： " + total);
		
	}
	
}
