package com.itheima.core.controller;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Brand;
import com.itheima.core.pojo.product.Color;
import com.itheima.core.pojo.product.Product;
import com.itheima.core.service.product.BrandService;
import com.itheima.core.service.product.ColorService;
import com.itheima.core.service.product.ProductService;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.08.02
 * @Description: com.itheima.core.service
 * @version: 1.0
 */
@Controller
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ColorService colorService;

    /**
     * 商品管理列表
     * @return
     */
    @RequestMapping(value = "/product/list.do")
    public String productList(Integer pageNo, String name, Long brandId, Boolean isShow, Model model){
        Pagination pagination =  productService.selectProList(pageNo,name,brandId,isShow);
        //查询品牌的结果集
        List<Brand> brandList = brandService.selectBrandListByQuery(null,1);
        model.addAttribute("brandList",brandList);
        model.addAttribute("name",name);
        model.addAttribute("isShow",isShow);
        model.addAttribute("brandId",brandId);
        model.addAttribute("pagination",pagination);
        return "product/list";
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping(value = "/product/toAdd.do")
    public String toAdd(Model model){
        List<Brand> brands = brandService.selectBrandListByQuery(null,1);
        List<Color> colors = colorService.selectColoList();
        model.addAttribute("brands",brands);
        model.addAttribute("colors",colors);
        return "product/add";
    }

    /**
     * 商品保存
     * @param product
     * @return
     */
    @RequestMapping("/product/add.do")
    public String insertPro(Product product){
        productService.insertProduct(product);
        return "redirect:/product/list.do";
    }

    @RequestMapping("/product/isShow.do")
    public String isShow(Long[] ids) throws IOException, SolrServerException {
        productService.isShow(ids);
        return "forward:/product/list.do";
    }
}
