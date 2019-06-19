package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo info = dao.findByUsername(username);
        List<Role> roles = info.getRoles();

        List<SimpleGrantedAuthority> authoriyt = getAuthoriyt(roles);

        User user = new User(info.getUsername(),"{noop}"+info.getPassword(),info.getStatus() == 0? false:true,true,true,true,authoriyt);

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthoriyt(List<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role r : roles ) {
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        }

        return authorities;
    }
}
