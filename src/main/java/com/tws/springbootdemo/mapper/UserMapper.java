package com.tws.springbootdemo.mapper;

import com.tws.springbootdemo.entity.Permission;
import com.tws.springbootdemo.entity.Role;
import com.tws.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author taoweishu
 * @date 2021/10/18 - 18:00
 */
@Mapper
public interface UserMapper {

    User getUserById(Long id);

    User loadUserByUsername(@Param("username") String username);

    @Select("select * from ")
    List<Permission> getPermissionList(Long id);

    int register(User user);

    int updateUserEmail(@Param("email") String email, @Param("id") Long id);

    List<User> getUserByNickname(@Param("nickname") String nickname);

    List<Role> getAllRole();

    int updateUserEnabled(@Param("enabled") Boolean enabled, @Param("uid") Long uid);

    int deleteUserById(Long uid);

    int deleteUserRolesByUid(Long id);

    int setUserRoles(@Param("rids") Long[] rids, @Param("id") Long id);

}
