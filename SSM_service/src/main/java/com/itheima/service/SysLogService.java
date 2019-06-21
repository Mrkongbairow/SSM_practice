package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog);

    List<SysLog> findAll();
}
