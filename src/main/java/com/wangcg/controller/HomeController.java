package com.wangcg.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  wangcg
 */
// 注解标注此类为springmvc的controller，url映射为"/home"
@RestController
@RequestMapping("/home")
public class HomeController {


    //映射一个action
    @RequestMapping("/data")
    public  String data(){
        return "data";
    }
}