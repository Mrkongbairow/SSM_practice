package com.itheima.controller;

import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<UserInfo> userInfos = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", userInfos);
        mv.setViewName("user-list");

        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {

        service.save(userInfo);

        return "redirect:findAll";
    }


    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

}
