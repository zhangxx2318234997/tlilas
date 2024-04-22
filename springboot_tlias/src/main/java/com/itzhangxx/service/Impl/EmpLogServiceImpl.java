package com.itzhangxx.service.Impl;

import com.itzhangxx.mapper.EmpLogMapper;
import com.itzhangxx.pojo.EmpLog;
import com.itzhangxx.service.EmpLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpLogServiceImpl implements EmpLogService {
    @Autowired
    private EmpLogMapper empLogMapper;

    @Override
    public void insertEmpLogById(EmpLog empLog) {
        empLogMapper.insertEmpLogById(empLog);
    }
}
