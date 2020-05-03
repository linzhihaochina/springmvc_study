package com.youngforcoding.controller;

import com.youngforcoding.dao.ResumeDao;
import com.youngforcoding.dao.UserDao;
import com.youngforcoding.pojo.Resume;
import com.youngforcoding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    public ModelAndView listInfo(String username, String password, HttpSession httpSession) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (username == null || password == null) {
            if (httpSession.getAttribute("username") == null || "".equals(httpSession.getAttribute("username"))
                    || httpSession.getAttribute("password") == null || "".equals(httpSession.getAttribute("password"))) {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("redirect:/test/login");
                return modelAndView;
            }
            username = httpSession.getAttribute("username").toString();
            password = httpSession.getAttribute("password").toString();
            user.setUsername(username);
            user.setPassword(password);
        } else {
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
        }
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

    @RequestMapping("addPage")
    public String addPage() {
        return "add";
    }

    @RequestMapping("add")
    public ModelAndView add(String name, String address, String phone) {
        Resume resume = new Resume();
        resume.setName(name);
        resume.setAddress(address);
        resume.setPhone(phone);
        resumeDao.save(resume);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/test/listInfo");
        return modelAndView;
    }

    @RequestMapping("delete")
    public ModelAndView delete(Long id) {
        resumeDao.deleteById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/test/listInfo");
        return modelAndView;
    }

}
