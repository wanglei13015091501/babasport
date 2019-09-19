package com.itheima.core.service;

import com.itheima.core.dao.user.BuyerDao;
import com.itheima.core.pojo.user.Buyer;
import com.itheima.core.pojo.user.BuyerQuery;
import com.itheima.core.service.buyer.BuyerService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.09.19
 * @Description: com.itheima.core.service
 * @version: 1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerDao buyerDao;

    @Override
    public Buyer selectBuyerByUsername(String username) {
        BuyerQuery buyerQuery = new BuyerQuery();
        buyerQuery.createCriteria().andUsernameEqualTo(username);
        List<Buyer> buyers = buyerDao.selectByExample(buyerQuery);
        if (CollectionUtils.isNotEmpty(buyers)){
            return buyers.get(0);
        }else{
            return null;
        }
    }
}
