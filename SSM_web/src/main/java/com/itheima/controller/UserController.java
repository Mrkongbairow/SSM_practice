package com.itheima.controller;

import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
   @Autowired
   private UserService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<UserInfo>  userInfos = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",userInfos);
        mv.setViewName("user-list");

        return mv;
    }
    @RequestMapping("/save")
    public String save(UserInfo userInfo){

        service.save(userInfo);

        return "redirect:findAll";
    }

}
