package com.youngforcoding.controller;

import com.youngforcoding.annotation.Controller;
import com.youngforcoding.annotation.RequestMapping;
import com.youngforcoding.annotation.Security;

/**
 *    
 *  *  
 *  * @Description:  [一句话描述该类的功能]   
 *  * @Author:       linZhiHao   
 *  * @CreateDate:   2020-05-03 11:24   
 *  *    
 *  
 */
@Controller
@RequestMapping("/demo")
public class MyController {

    @RequestMapping("/handle01")
    @Security(value = {"admin"})
    public String handle(String username){
        return "go!!!";
    }


}
