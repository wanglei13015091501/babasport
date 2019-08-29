package com.itheima.core.dao.product;

import com.itheima.core.pojo.product.Brand;
import com.itheima.core.pojo.product.BrandQuery;

import java.util.List;

public interface BrandDao {
	
	
	//查询结果集  想查所有  想查就分页
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);

	//查询总条数
	public Integer countBrandByQuery(BrandQuery brandQuery);
	//通过Id查询一个品牌对象
	public Brand selectBrandById(Long id);

	//修改品牌
	public void editBrand(Brand brand);

	//批量删除
	public void batchDelete(Long[] ids);
}
