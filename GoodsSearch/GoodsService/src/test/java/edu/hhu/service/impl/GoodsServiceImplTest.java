package edu.hhu.service.impl;

import java.awt.event.ItemListener;
import java.util.List;

import com.github.pagehelper.PageInfo;
import edu.hhu.domain.Goods;
import edu.hhu.service.GoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.hhu.BaseTest;

public class GoodsServiceImplTest extends BaseTest {
	@Autowired
	@Qualifier("GoodsServiceImpl")
	private GoodsService goodsService;

	@Test
	public void goodsListTest(){
        PageInfo pageInfo = goodsService.goodsList(1,5);
        List<Goods> goodsList = pageInfo.getList();
        for (Goods goods : goodsList) {
            System.out.println(goods.getGoodsId());
            System.out.println(goods.getGoodsName());
        }
	}
}
