package com.gs.service.user;

import com.gs.entity.UserInfo;
import com.gs.util.PageBean;

import java.util.List;

public interface UserService {
    UserInfo queryUserByUserName(String userName);

    void pagingQueryUser(PageBean<UserInfo> pageBean, UserInfo userInfo);

    void updateUser(UserInfo user);

    UserInfo queryUserById(Integer id);

    void saveUser(UserInfo userInfo);

    List<UserInfo> queryUser();
}
