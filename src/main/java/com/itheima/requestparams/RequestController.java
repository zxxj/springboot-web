package com.itheima.requestparams;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

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

    // 实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return  "OK";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        // 实体对象参数: 请求参数与形参对象属性名相同,即可直接通过POJO接收
        System.out.println(user);
        return  "OK";
    }
}
