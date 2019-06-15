package edu.hhu.controller;

import com.github.pagehelper.PageInfo;
import edu.hhu.domain.Goods;
import edu.hhu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 邓宁
 * @Date: Created in 23:07 2018/12/26
 */


@Controller("GoodsController")
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    @Qualifier("GoodsService")
    private GoodsService goodsService;

    @RequestMapping("listGoods")
    public String listGoods(Model model,
            @RequestParam(value = "page",defaultValue = "1",required = false)Integer page,
            @RequestParam(value = "countOfPage",defaultValue = "4",required = false)Integer countOfPage){

        PageInfo<Goods> pageInfo = goodsService.goodsList(page, countOfPage);
        model.addAttribute("pageInfo", pageInfo);

        return "goods/list";
    }
}
