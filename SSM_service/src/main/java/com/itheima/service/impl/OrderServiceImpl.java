package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrderDao;
import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;

    @Override
    public List<Orders> findAllByPage(int pageNum,int pageSize) {
        //pageNum页码值，pageSize每页显示条数
        PageHelper.startPage(pageNum,pageSize);
        return dao.findAll();
    }

    @Override
    public Orders findById(String id) {
        Orders byId = dao.findById(id);
        return byId;
    }
}
