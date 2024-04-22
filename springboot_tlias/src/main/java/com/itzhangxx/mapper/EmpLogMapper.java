package com.itzhangxx.mapper;

import com.itzhangxx.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {

    @Insert("insert tlias.emp_log(create_time, description) " +
            " values( #{createTime} , #{description}) ")
    void insertEmpLogById(EmpLog empLog);
}
