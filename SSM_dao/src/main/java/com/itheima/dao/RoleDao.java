package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({@Result(id = true,column = "id" ,property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc" ,property = "roleDesc"),
            @Result(column = "id" ,property = "permissions",javaType = List.class,many=@Many(select = "com.itheima.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
