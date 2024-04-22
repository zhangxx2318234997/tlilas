package com.itzhangxx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code; //响应码 1:成功 0:失败
    private String msg; //响应信息，描述字段
    private Object data; //返回数据

    public static Result success(){//增删改 成功响应
        return new Result(1,"success",null);
    }
    public static Result success(Object data){//查询 成功响应
        return new Result(1,"success",data);
    }
    public static Result error(String msg){//失败
        return new Result(0,msg,null);
    }


}
