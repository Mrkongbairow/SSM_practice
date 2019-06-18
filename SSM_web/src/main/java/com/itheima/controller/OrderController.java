package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    //未分页
    /*@RequestMapping("/findAll")//@RequestParam(name="page" , required = true ,defaultValue = "1")Integer page,@RequestParam(name="pagesize",required = true,defaultValue = "5")Integer pageSize
    public ModelAndView findAll(){
        List<Orders> orderList = service.findAllByPage();
        //PageInfo pageInfo = new PageInfo(orderList);
        ModelAndView vm = new ModelAndView();
        vm.addObject("ordersList",orderList);
        vm.setViewName("orders-list");

        return vm;
    }*/
    //分页查询
    @RequestMapping("/findAll")//@RequestParam(name="page" , required = true ,defaultValue = "1")Integer page,@RequestParam(name="pagesize",required = true,defaultValue = "5")Integer pageSize
    public ModelAndView findAll(@RequestParam(name="page" , required = true ,defaultValue = "1")Integer page,@RequestParam(name="pageSize",required = true,defaultValue = "5")Integer pageSize){
        //!!!!
        List<Orders> orderList = service.findAllByPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(orderList);
        ModelAndView vm = new ModelAndView();
        vm.addObject("pageInfo",pageInfo);
        vm.setViewName("orders-page-list");

        return vm;
    }


}
