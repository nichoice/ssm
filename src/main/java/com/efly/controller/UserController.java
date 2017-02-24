package com.efly.controller;

import com.efly.pojo.User;
import com.efly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nic on 2017/1/23.
 * 用户登录控制器
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/login.do" , method = RequestMethod.POST)
    public String Login(String username , String password , Model model) throws Exception{
        User user = userService.selectCheckUser(username, password);
        if(user != null){
            model.addAttribute("msg" , user);
            List<User> list = new ArrayList<User>();
            list = userService.selectAllUser();
            model.addAttribute("users" , list);
            return "main";
        } else{
            model.addAttribute("msg" , "用户名或者密码不对。");
            return "index";
        }
    }

    @RequestMapping(value = "/add.do" , method = RequestMethod.POST)
    public String AddUser(String username , String password , Model model) throws Exception{
        try {
            userService.insertUser(username, password);
        }catch (Exception e){
            model.addAttribute("msg" , "该用户已存在！");
        }
        List<User> list = new ArrayList<User>();
        list = userService.selectAllUser();
        model.addAttribute("users" , list);
        return "main";
    }

    @RequestMapping(value = "/{id}/update.do" , method = RequestMethod.POST)
    public String updateUser(String username , String password , int id , Model model){

        return "main";
    }

    @RequestMapping(value = "/delete.do" )
    public void deleteUser(int id , HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = "{\"result\":\"error\"}";
        if(userService.deleteUser(id)){
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/logout.do")
    public String Logout(HttpSession session) throws Exception{
        session.invalidate();
        return "index";
    }
}
