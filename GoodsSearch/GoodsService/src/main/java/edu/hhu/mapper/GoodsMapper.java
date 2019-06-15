package edu.hhu.mapper;

import java.util.List;

import edu.hhu.domain.Goods;
import org.springframework.stereotype.Repository;


@Repository("GoodsMapper")
public interface GoodsMapper {
	
    public List<Goods> listGoods();
}