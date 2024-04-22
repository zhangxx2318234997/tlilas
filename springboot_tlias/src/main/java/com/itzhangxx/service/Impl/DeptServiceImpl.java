package com.itzhangxx.service.Impl;

import com.itzhangxx.mapper.DeptMapper;
import com.itzhangxx.mapper.EmpMapper;
import com.itzhangxx.pojo.Dept;
import com.itzhangxx.pojo.DeptLog;
import com.itzhangxx.service.DeptLogService;
import com.itzhangxx.service.DeptService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/*
* 部门管理
* */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;




    /*
     * 查询全部部门数据
     * */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }


    /*
     * 删除部门
     * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id); // 根据id删除部门
//            int i = 1/0;
            empMapper.deleteByDeptId(id); // 根据部门id解散部门下的员工

        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，本次解散的部门是"+id+"号部门");
            deptLogService.insertDeptLogById(deptLog);
        }
    }


    /*
     * 新增部门
     * */
    @Override
    public void add(@NotNull Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    /*
     * 修改部门
     * */
    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getByID(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
