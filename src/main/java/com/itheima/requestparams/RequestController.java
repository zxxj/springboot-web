package com.itheima.requestparams;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {

// 一.获取参数的方式
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request) {
//
//        // 1.原始方式: 在原始的web程序中,如果需要获取请求参数,需要通过HttpServletRequest对象来手动获取,并且需要手动进行数据类型的转换
//
//        // 获取请求参数
//        String name  = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//
//        int age = Integer.parseInt(ageStr);
//
//        System.out.println("name:" + name + "age:" + age);
//
//        return "ok";
//    }

//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name, Integer age) {
//        // 2.springboot方式: 简单的参数: 参数名与形参变量名相同,定义形参即可接收到参数并且会自动进行数据类型的转换
//        System.out.println("name:" + name + "age:" + age);
//        return "ok";
//    }

    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name", required = false) String username, Integer age) {
        // 3.springboot方式: 使用RequestParam注解
        // 方法的形参与请求参数名称不匹配,通过该注解完成映射
        // 该注解的required属性默认为true,代表请求参数必须传递,不传则会报错
        System.out.println("name:" + username + "age:" + age); // null 20
        return "ok";
    }

    // 二.实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return  "OK";
    }

    // 三.对象实体参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        // 实体对象参数: 请求参数与形参对象属性名相同,即可直接通过POJO接收
        System.out.println(user);
        return  "OK";
    }

    // 四.数组集合参数（1.使用数组来对参数进行封装）
    // 请求参数名与形参中数组变量名相同，可以直接使用数组封装
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    // 数组集合参数（2.使用集合来对参数进行封装）
    // 请求参数名与形参中集合变量名相同，通过@RequestParam绑定参数关系
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    // 五.日期时间参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    // 六.JSON参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        // JSON数据键名与形参对象属性名相同,定义POJO类型形参即可接收参数,需要使用@RequestBody标识
        System.out.println(user);
        return "OK";
    }

    // 七.路径参数

    // 单个参数
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "OK";
    }

    // 多个参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }
}
