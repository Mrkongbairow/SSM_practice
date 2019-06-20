package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.apache.ibatis.annotations.Param;
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
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id" ,required = true) String Id) throws Exception {
        //根据Id查找用户
        UserInfo user = service.findById(Id);
        //根据userid查找其他角色
        List<Role> roleList = service.findOtherRole(Id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roleList);
        mv.addObject("user",user);

        mv.setViewName("user-role-add");

        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId,String[] ids){
        service.addRoleToUser(userId,ids);

        return "redirect:findAll";
    }



}
