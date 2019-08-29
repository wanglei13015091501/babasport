package com.itheima.core.controller;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Brand;
import com.itheima.core.service.product.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * 品牌管理
 * @author lx
 *
 */
@Controller
public class BrandController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BrandService brandService;
	//品牌管理之列表查询
	@RequestMapping(value = "/brand/list.do")
	public String list(Integer pageNo, String name, Integer isDisplay, Model model){
//		查询分页对象
		Pagination pagination = brandService.selectPaginationByQuery(pageNo, name, isDisplay);
//		查询结果集
		//List<Brand> brands = brandService.selectBrandListByQuery(name, isDisplay);
		model.addAttribute("pagination", pagination);
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		
		
		return "brand/list";
	}
	//去修改页面
	@RequestMapping(value = "/brand/toEdit.do")
	public String toEdit(Long id,Model model){
		Brand brand = brandService.selectBrandById(id);
		model.addAttribute("brand", brand);
		return "brand/edit";
	}

	/**
	 * 品牌详情修改
	 * @param brand
	 * @return
	 */
	@RequestMapping(value = "/brand/edit.do")
	public String editBrand(Brand brand){
		log.debug("edit Brand {}",brand);
		brandService.editBrand(brand);
		return "redirect:/brand/list.do";
	}

	/**
	 * 批量删除品牌
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/brand/batchDelete.do")
	public String batchDelete(HttpServletRequest request, @RequestParam(required = true) Long[] ids){
		log.debug("batch delete Brand {}",ids);
		brandService.batchDelete(ids);
		return "forward:/brand/list.do";
	}
}
