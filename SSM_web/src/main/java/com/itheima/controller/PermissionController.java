package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Permission> permissionList = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Permission permission){
        service.save(permission);

        return "redirect:findAll";
    }

}
