package com.example.reiggie_take_out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.reiggie_take_out.mapper.EmployeeMapper;
import com.example.reiggie_take_out.service.EmployeeService;
import org.springframework.stereotype.Service;
import com.example.reiggie_take_out.entity.Employee;

/**
 * Created by XU on 2023/4/14 15:46
 */
//@Service    // 交给spring管理
//public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> {
// 是EmployeeService的实现类却没有做，只写了继承ServiceImpl
//}
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
}