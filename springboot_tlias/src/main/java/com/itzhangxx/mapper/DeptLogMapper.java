package com.itzhangxx.mapper;

import com.itzhangxx.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {

    @Insert("insert tlias.dept_log (create_time, description) " +
            "values(#{createTime},#{description}) ")
    void insertDeptLogById(DeptLog deptLog);
}
