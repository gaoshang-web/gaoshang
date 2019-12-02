package com.gs.service.user.impl;

import com.gs.dao.UserMapper;
import com.gs.entity.UserInfo;
import com.gs.service.user.UserService;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    public UserInfo queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);
    }

    public void pagingQueryUser(PageBean<UserInfo> pageBean, UserInfo userInfo) {
        Long totalCount = userDao.totalNumber(userInfo);
        pageBean.setRecordsTotal(totalCount);
        pageBean.setRecordsFiltered(totalCount);
        List<UserInfo> userList = userDao.pagingQueryUser(pageBean, userInfo);
        pageBean.setData(userList);
    }

    public void updateUser(UserInfo user) {

        userDao.updateUser(user);
    }

    public UserInfo queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    public void saveUser(UserInfo userInfo) {
        userInfo.setLoginCount(0);
        userDao.saveUser(userInfo);
    }

    public List<UserInfo> queryUser() {
        return userDao.queryUser();
    }
}
