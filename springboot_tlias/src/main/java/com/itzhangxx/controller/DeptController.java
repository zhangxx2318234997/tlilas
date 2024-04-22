package com.itzhangxx.controller;


import com.itzhangxx.pojo.Dept;
import com.itzhangxx.pojo.Result;
import com.itzhangxx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* 部门管理
* */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /*
     * 查询全部部门数据
     * */
    @GetMapping
    public Result list(){
        log.info("查询全部部门");
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }

    /*
    * 删除部门
    * */
    @DeleteMapping("/{id}")
    public Result deletc(@PathVariable Integer id){
        log.info("根据id删除部门:",id);
        deptService.delete(id);
        return Result.success();
    }

    /*
    * 新增部门
    * */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:",dept);
        deptService.add(dept);
        return Result.success();
    }

    /*
    * 修改部门
    * */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("获取部门ID:",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
