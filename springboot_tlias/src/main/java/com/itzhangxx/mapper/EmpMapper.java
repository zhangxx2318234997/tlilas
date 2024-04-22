package com.itzhangxx.mapper;

import com.itzhangxx.pojo.Emp;
import com.itzhangxx.pojo.EmpLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/*
 * 员工管理
 * */
@Mapper
public interface EmpMapper {

    /*
    * 查询总记录数
    * */
//    @Select("select COUNT(*) from tlias.emp")
//    public Long count();
//
//    @Select("select * from tlias.emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);

    /*
     * 员工信息查询
     * */
//        @Select("select * from tlias.emp")
        public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /*
     * 批量删除
     * */
    void delete(List<Integer> ids);

    /*
     * 新增员工
     * */
    @Insert("insert tlias.emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "value ( #{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);

    /*
     * 页面回显,根据id查询
     * */
    @Select("select * from tlias.emp where id = #{id}")
    Emp getById(Integer id);


    /*
     * 修改员工
     * */
    void update(Emp emp);

    /*
     * 员工登录
     * */
    @Select("select * from tlias.emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /*
    * 根据部门id删除员工数据
    * */
    @Delete("delete from tlias.emp where dept_id = #{DeptId}")
    void deleteByDeptId(Integer DeptId);



}
