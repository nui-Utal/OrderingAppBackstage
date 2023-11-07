package com.example.reiggie_take_out.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.reiggie_take_out.common.R;
import com.example.reiggie_take_out.entity.Employee;
import com.example.reiggie_take_out.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * Created by XU on 2023/4/14 15:48
 */
//@Slf4j  // 便于日志调试
//@RestController // 声明为controller且能够被扫描到
//@RequestMapping("/employee") // 基础响应路径
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    /**
//     * 员工登录
//     * @param request
//     * @param employee
//     * @return
//     */
//    @PostMapping("/login")
//    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
//        // 得到session的数据、得到函数体中的json对象（json数据的命名和类的属性的命名相同）
//        // 1、将提交的密码进行md5加密
//        String password = employee.getPassword();
//        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
//
//        // 2、根据页面提交的用户名username查询数据库
//        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Employee::getUsername, employee.getUsername());
//        Employee emp = (Employee) employeeService.getOne(wrapper); // 用户名唯一，所以调用getOne
//
//        // 3、如果没有查询到则返回登录失败结果
//        if(emp == null) {
//            return R.error("登陆失败");
//        }
//
//        // 4、密码比对，如果不一致则返回登录失败结果
//        if(!emp.getPassword().equals(password)) {
//            return R.error("登陆失败");
//        }
//
//        // 5、查看员工状态，如果为已禁用状态，则返回相应的msg“员工已禁用结果”
//        if(emp.getStatus() == 0) { // 等于0表示已禁用
//            return R.error("账号已禁用");
//        }
//
//        // 6、登录成功，将员工id存入Session并返回登录成功结果
//        request.getSession().setAttribute("employee", emp.getId());
//        return R.success(emp);
//    }

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request,@RequestBody Employee employee){

        //1、将页面提交的密码password进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if(emp == null){
            return R.error("登录失败");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if(!emp.getPassword().equals(password)){
            return R.error("登录失败");
        }

        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if(emp.getStatus() == 0){
            return R.error("账号已禁用");
        }

        //6、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

}
