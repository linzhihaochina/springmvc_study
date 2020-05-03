package com.youngforcoding.controller;

import com.youngforcoding.dao.ResumeDao;
import com.youngforcoding.dao.UserDao;
import com.youngforcoding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 *    
 *  *  
 *  * @Description:  [一句话描述该类的功能]   
 *  * @Author:       linZhiHao   
 *  * @CreateDate:   2020-05-03 13:14   
 *  *    
 *  
 */
@Controller
@RequestMapping("/test")
public class MyController {

    @Autowired
    private ResumeDao resumeDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/listInfo")
    public ModelAndView listInfo(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        List<User> all = userDao.findAll(Example.of(user));
        if (username == null || password == null || "".equals(username)
                || "".equals(password) || all == null || all.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/test/login");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", resumeDao.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
