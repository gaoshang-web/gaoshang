package com.gs.dao;

import com.gs.entity.UserInfo;
import com.gs.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    UserInfo queryUserByUserName(String userName);

    Long totalNumber(@Param("userInfo") UserInfo userInfo);

    List<UserInfo> pagingQueryUser(@Param("pageBean") PageBean<UserInfo> pageBean,@Param("userInfo") UserInfo userInfo);

    void updateUser(UserInfo user);

    UserInfo queryUserById(Integer id);

    void saveUser(UserInfo userInfo);

    List<UserInfo> queryUser();
}
