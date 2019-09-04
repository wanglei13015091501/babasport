package com.itheima.core.controller;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Brand;
import com.itheima.core.service.solr.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private SolrService solrService;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/search")
    public String search(Integer pageNo, String keyword, Model model) throws Exception {
        //从redis缓存中获取品牌结果集
        List<Brand> brandList = solrService.selectBrandList();
        Pagination pagination = solrService.selectPaginationByQuery(pageNo,keyword);
        model.addAttribute("keyword",keyword);
        model.addAttribute("pagination",pagination);
        model.addAttribute("brandList",brandList);
        return "search";
    }
}
