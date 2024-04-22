package com.itzhangxx.controller;


import com.itzhangxx.pojo.Emp;
import com.itzhangxx.pojo.PageBean;
import com.itzhangxx.pojo.Result;
import com.itzhangxx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/*
* 员工管理
* */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /*
     * 分页查询
     * */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                        String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询，参数:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);

        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);

        return Result.success(pageBean);
    }


    /*
     * 批量删除
     * */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    /*
    * 新增员工
    * */
    @PostMapping()
    public Result save(@RequestBody Emp emp){
        log.info("新增员工:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    /*
    * 页面回显,根据id查询
    * */
    @GetMapping("/{id}")
    public Result geyById(@PathVariable Integer id){

        log.info("根据id插叙信息:{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /*
    * 修改员工
    * */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息:{}",emp);

        empService.update(emp);
        return Result.success();
    }
}
