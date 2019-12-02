package com.gs.dao;

import com.gs.entity.LogInfo;
import com.gs.util.PageBean;

import java.util.List;

public interface LogMapper {
    void saveLog(LogInfo logInfo);

    Long totalNumber();

    List<LogInfo> pagingQueryLog(PageBean<LogInfo> pageBean);
}
