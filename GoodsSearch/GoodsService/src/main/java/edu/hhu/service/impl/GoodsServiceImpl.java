package edu.hhu.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hhu.domain.Goods;
import edu.hhu.service.GoodsService;
import edu.hhu.util.JedisClient;
import edu.hhu.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.hhu.mapper.GoodsMapper;

@Service("GoodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
    @Qualifier("GoodsMapper")
    private GoodsMapper goodsMapper;

    @Autowired
    @Qualifier("JedisClientImpl")
    private JedisClient jedisClient;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public PageInfo<Goods> goodsList(Integer pageNow, Integer pageSize) {

        //从Redis缓存中获取当前页数据
        String json = jedisClient.get("GoodsPage:" + pageNow);
        //Redis数据库不为空
        if (!StringUtils.isBlank(json)){
            return JsonUtils.jsonToPojo(json,PageInfo.class);
        }

        PageInfo<Goods> goodsPageInfo;
	    try {
            PageHelper.startPage(pageNow,pageSize);
            List<Goods> goodsList = goodsMapper.listGoods();
            goodsPageInfo = new PageInfo<>(goodsList);
            //放入Redis数据库
            jedisClient.set("GoodsPage:"+pageNow,JsonUtils.objectToJson(goodsPageInfo));
            return goodsPageInfo;

        }catch (Exception e){
	        e.printStackTrace();
	        throw new RuntimeException(e);
        }
    }
}
