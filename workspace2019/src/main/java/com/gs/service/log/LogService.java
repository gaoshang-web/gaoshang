package com.gs.service.log;

import com.gs.entity.LogInfo;
import com.gs.util.PageBean;

public interface LogService {
    void saveLog(LogInfo logInfo);

    void pagingQueryLog(PageBean<LogInfo> pageBean);
}
