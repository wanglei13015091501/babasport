package com.itheima.core.service.message;

import com.itheima.core.service.solr.SolrService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 自定义activeMQ消息处理类
 * @Auther: wanglei
 * @Date: 2019.09.16
 * @Description: com.itheima.common.activemq
 * @version: 1.0
 */
public class CustomMessageListener implements MessageListener {
    @Autowired
    private SolrService solrService;

    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage atm = (ActiveMQTextMessage)message;
        //接收消息中的商品id
        try {
            String id = atm.getText();
            System.out.println(id);
            //保存商品到solr服务器
            solrService.insertProductToSolr(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
