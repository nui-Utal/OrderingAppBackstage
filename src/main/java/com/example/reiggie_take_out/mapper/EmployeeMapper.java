package com.example.reiggie_take_out.mapper;

/*import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.reiggie_take_out.entity.Employee;

*//**
 * Created by XU on 2023/4/14 15:40
 *//*
 @Mapper // 没有mapper的注解
public interface EmployeeMapper extends BaseMapper<Employee> {
}*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.reiggie_take_out.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{
}
