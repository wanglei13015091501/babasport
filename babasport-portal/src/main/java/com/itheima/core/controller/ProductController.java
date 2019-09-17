package com.itheima.core.controller;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Brand;
import com.itheima.core.service.solr.SolrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private SolrService solrService;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    /**
     * 前端搜索页面
     * @param price
     * @param brandId
     * @param pageNo
     * @param keyword
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/search")
    public String search(String price,Long brandId,Integer pageNo, String keyword, Model model) throws Exception {
        //从redis缓存中获取品牌结果集
        List<Brand> brandList = solrService.selectBrandList();
        Pagination pagination = solrService.selectPaginationByQuery(pageNo,keyword,brandId,price);
        Map<String,String> map = new HashMap<String,String>();
        if (brandId!=null){
            for (Brand brand :brandList) {
                if (brand.getId().equals(brandId)){
                    map.put("品牌",brand.getName());
                    break;
                }
            }
        }
        if (StringUtils.isNotBlank(price)){
            if (price.contains("-")){
                map.put("价格",price);
            }else{
                map.put("价格",price+"以上");
            }
        }
        model.addAttribute("map",map);
        model.addAttribute("keyword",keyword);
        model.addAttribute("pagination",pagination);
        model.addAttribute("brandList",brandList);
        return "search";
    }

    /**
     * 去商品详情页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/product/detail")
    public String detail(@RequestParam(value = "id",required = false)Long id, Model model){
        //商品信息

        return "product";
    }
}
