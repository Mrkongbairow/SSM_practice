package com.itheima.dao;

import com.itheima.domain.Permission;
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

    @Select("select * from role where id = #{id}")
    Role findById(String id);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findOtherPermissionById(String id);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
