package com.itheima.test;


import com.itheima.dao.OrderDao;
import com.itheima.dao.ProductDao;

import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

import java.util.List;

public class Test01 {
    @Test
    public void testItems(){
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
        ProductDao bean = app.getBean(ProductDao.class);
        List<Product> all = bean.findAll();
        System.out.println(all);
    }
    @Test
    public void testItems2() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
        OrderDao bean = app.getBean(OrderDao.class);
        List<Orders> all = bean.findAll();
        System.out.println(all);
    }
    @Test
    public void testItems3() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
        ProductDao bean = app.getBean(ProductDao.class);
        Product byId = bean.findById("676C5BD1D35E429A8C2E114939C5685A");
        System.out.println(byId);
    }
}
