package com.itzhangxx.service.Impl;

import com.itzhangxx.mapper.DeptLogMapper;
import com.itzhangxx.pojo.DeptLog;
import com.itzhangxx.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertDeptLogById(DeptLog deptLog){
        deptLogMapper.insertDeptLogById(deptLog);
    }


}
