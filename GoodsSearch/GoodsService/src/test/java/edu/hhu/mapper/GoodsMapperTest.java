package edu.hhu.mapper;

import java.util.List;

import edu.hhu.domain.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.hhu.BaseTest;

//测试类
public class GoodsMapperTest extends BaseTest{
	@Autowired
	@Qualifier("GoodsMapper")
	private GoodsMapper goodsMapper;
	
	@Test
	public void listGoodsTest(){
		List<Goods> goodsList = goodsMapper.listGoods();
		for (Goods goods : goodsList) {
			System.out.println(goods.getGoodsName());
			System.out.println(goods.getGoodsPrice());
			System.out.println(goods.getGoodsType().getTypeId());
			System.out.println(goods.getGoodsType().getTypeName());
		}
		
	}

}
