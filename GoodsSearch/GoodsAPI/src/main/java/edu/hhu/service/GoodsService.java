package edu.hhu.service;

import com.github.pagehelper.PageInfo;
import edu.hhu.domain.Goods;

import java.util.List;

/**
 * @Author: 邓宁
 * @Date: Created in 22:16 2018/12/24
 */

public interface GoodsService {

    public PageInfo<Goods> goodsList(Integer pageNow, Integer pageSize);
}
