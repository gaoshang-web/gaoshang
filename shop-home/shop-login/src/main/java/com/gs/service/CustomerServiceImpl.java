package com.gs.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gs.dao.CustomerMapper;
import com.gs.entity.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerDao;

    @Override
    public CustomerInfo phoneRegister(String phone) {
        QueryWrapper<CustomerInfo> queryWrapper=new QueryWrapper<CustomerInfo>();
        queryWrapper.eq("phone", phone);
        CustomerInfo customerInfo = customerDao.selectOne(queryWrapper);
        if (customerInfo == null){
            customerInfo = new CustomerInfo();
            customerInfo.setUpdateTime(new Date());
            customerInfo.setLoginState(1);
            customerInfo.setPhone(phone);
            customerInfo.setCartId(UUID.randomUUID().toString().replace("-", ""));
            customerDao.insert(customerInfo);
        }else {
            customerInfo.setUpdateTime(new Date());
            customerDao.updateById(customerInfo);
        }
        return customerInfo;
    }
}
