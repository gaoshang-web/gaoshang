package com.gs.service.log.impl;

import com.gs.dao.LogMapper;
import com.gs.entity.LogInfo;
import com.gs.service.log.LogService;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logDao;

    public void saveLog(LogInfo logInfo) {
        logDao.saveLog(logInfo);
    }

    public void pagingQueryLog(PageBean<LogInfo> pageBean) {
        Long totalCount = logDao.totalNumber();
        pageBean.setRecordsTotal(totalCount);
        pageBean.setRecordsFiltered(totalCount);
        List<LogInfo> logList = logDao.pagingQueryLog(pageBean);
        pageBean.setData(logList);
    }
}
