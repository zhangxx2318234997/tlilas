package com.itzhangxx.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itzhangxx.mapper.EmpMapper;
import com.itzhangxx.pojo.DeptLog;
import com.itzhangxx.pojo.EmpLog;
import com.itzhangxx.pojo.PageBean;
import com.itzhangxx.service.EmpLogService;
import com.itzhangxx.service.EmpService;
import com.itzhangxx.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
 * 员工管理
 * */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpLogService empLogService;

    /*
     * 分页查询
     * */
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        // 1.获取总记录数
//        Long count = empMapper.count();
//
//        // 2.获取分页查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start,pageSize);
//
//        // 3.封装pageBean对象
//        PageBean pageBean = new PageBean(count,empList);
//
//        return pageBean;
//    }

    /*
     * 分页查询
     * */
    @Override
    public PageBean page(Integer page, Integer pageSize , String name, Short gender, LocalDate begin, LocalDate end){
        // 1.设置分页参数
        PageHelper.startPage(page,pageSize);

        // 2.执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        // 3.封装pageBean对象
        PageBean pageBean = new PageBean(p.getTotal() ,p.getResult());

        return pageBean;
    }

    /*
     * 批量删除
     * */
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);

        try {

        } finally {
            EmpLog empLog = new EmpLog();
            empLog.setCreateTime(LocalDateTime.now());
            empLog.setDescription("执行了删除员工的操作，本次删除的员工是"+ids+"号员工");
            empLogService.insertEmpLogById(empLog);
        }


    }


    /*
     * 新增员工
     * */
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);
    }


    /*
     * 页面回显,根据id查询
     * */
    @Override
    public Emp getById(Integer id) {

        return empMapper.getById(id);
    }


    /*
     * 修改员工
     * */
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /*
     * 员工登录
     * */
    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
