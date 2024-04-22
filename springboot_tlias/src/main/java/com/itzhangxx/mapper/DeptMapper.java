package com.itzhangxx.mapper;

import com.itzhangxx.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
 * 部门管理
 * */
@Mapper
public interface DeptMapper {
    /*
     * 查询全部部门数据
     * */

    @Select("select id, name, create_time, update_time from tlias.dept ")

    List<Dept> list();


    /*
     * 根据ID删除部门
     * */
    @Delete("delete from tlias.dept where id = #{id} ")
    void deleteById(Integer id);

    /*
     * 新增部门
     * */
    @Insert("insert tlias.dept (name, create_time, update_time) " +
            "values(#{name},#{createTime},#{updateTime}) ")
    void insert(Dept dept);



    @Select("select * from tlias.dept where id = #{id}")
    Dept getByID(Integer id);
    @Update("update tlias.dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);


}

