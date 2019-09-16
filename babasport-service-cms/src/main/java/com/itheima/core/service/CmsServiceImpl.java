package com.itheima.core.service;

import com.itheima.core.dao.product.ColorDao;
import com.itheima.core.dao.product.ProductDao;
import com.itheima.core.dao.product.SkuDao;
import com.itheima.core.pojo.product.Product;
import com.itheima.core.pojo.product.Sku;
import com.itheima.core.pojo.product.SkuQuery;
import com.itheima.core.service.cms.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.09.16
 * @Description: com.itheima.core.service
 * @version: 1.0
 */
@Service("cmsService")
public class CmsServiceImpl implements CmsService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private SkuDao skuDao;
    @Autowired
    private ColorDao colorDao;

    /**
     * 通过ID查询商品
     * @param id
     * @return
     */
    @Override
    public Product selectProductById(Long id) {
        return productDao.selectByPrimaryKey(id);
    }

    /**
     * 通过ID查询库存表,只查有货的
     * @param id
     * @return
     */
    @Override
    public List<Sku> selectSkuListByProductId(Long id) {
        SkuQuery skuQuery = new SkuQuery();
        skuQuery.createCriteria().andProductIdEqualTo(id).andStockGreaterThan(0);
        List<Sku> skus = skuDao.selectByExample(skuQuery);
        for (Sku sku : skus) {
            //通过SKU对象中的颜色ID查询对应的颜色表
            sku.setColor(colorDao.selectByPrimaryKey(sku.getColorId()));
        }
        return skus;
    }
}
