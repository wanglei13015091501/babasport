package com.itheima.core.service.product;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Brand;

import java.util.List;


public interface BrandService {
	
	
	//查询品牌结果集
	public List<Brand> selectBrandListByQuery(String name,Integer isDisplay);
	
	//查询分页对象
	public Pagination selectPaginationByQuery(Integer pageNo, String name, Integer isDisplay);
	
	//通过Id查询一个品牌对象
	public Brand selectBrandById(Long id);

	//修改品牌
	public void editBrand(Brand brand);

	//批量删除品牌
	public void batchDelete(Long[] ids);
}
