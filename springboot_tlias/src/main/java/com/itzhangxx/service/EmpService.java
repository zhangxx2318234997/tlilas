package com.itzhangxx.service;

import com.itzhangxx.pojo.Emp;
import com.itzhangxx.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;


/*
 * 员工管理
 * */
public interface EmpService {
    /*
    * 分页查询
    * */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /*
    * 批量删除
    * */
    void delete(List<Integer> ids);

    /*
     * 新增员工
     * */
    void save(Emp emp);

    /*
     * 页面回显,根据id查询
     * */
    Emp getById(Integer id);

    /*
     * 修改员工
     * */
    void update(Emp emp);


    /*
     * 员工登录
     * */
    Emp login(Emp emp);
}
