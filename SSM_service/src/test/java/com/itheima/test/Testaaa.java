package com.itheima.test;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Testaaa {
    @Test
    public void testItems(){
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
        ProductService bean = app.getBean(ProductService.class);
        List<Product> all = bean.findAll();
        System.out.println(all);
    }
}
