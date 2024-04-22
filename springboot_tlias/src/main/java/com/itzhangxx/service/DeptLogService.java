package com.itzhangxx.service;

import com.itzhangxx.pojo.DeptLog;
import org.springframework.stereotype.Service;

@Service
public interface DeptLogService {

    void insertDeptLogById(DeptLog deptLog);
}
