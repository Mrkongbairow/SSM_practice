package com.itheima.service;

import com.itheima.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderService {

    List<Orders> findAllByPage(int page,int pageSize);

    Orders findByid(String id);
}
