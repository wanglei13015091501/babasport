package com.itheima.core.service.product;

import com.itheima.core.dao.product.ColorDao;
import com.itheima.core.pojo.product.Color;
import com.itheima.core.pojo.product.ColorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.08.20
 * @Description: com.itheima.core.service.product
 * @version: 1.0
 */
@Service("colorService")
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorDao colorDao;

    @Override
    public List<Color> selectColoList() {
        ColorQuery colorQuery = new ColorQuery();
        colorQuery.createCriteria().andParentIdNotEqualTo(0L);
        return colorDao.selectByExample(colorQuery);
    }
}
