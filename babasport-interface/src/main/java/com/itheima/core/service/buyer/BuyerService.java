package com.itheima.core.service.buyer;

import com.itheima.core.pojo.user.Buyer;

/**
 * @Auther: wanglei
 * @Date: 2019.09.19
 * @Description: com.itheima.core.service.buyer
 * @version: 1.0
 */
public interface BuyerService {
    public Buyer selectBuyerByUsername(String username);
}
