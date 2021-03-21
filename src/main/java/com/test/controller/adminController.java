package com.test.controller;

import com.test.dto.AdminLoginDto;
import com.test.service.adminLogin.AdminLoginService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@Controller
public class adminController {


    @Autowired
    AdminLoginService adminloginService;

    @GetMapping("/admin")
    public String main(Model model){
        try{
            System.out.println("Start adminLogin");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "adminLogin";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String adminLogin(Model model, @RequestParam(value = "id") String id, @RequestParam(value = "password") String password){
        try{
            System.out.println("id: " + id);
            System.out.println("password: " + password);
            ArrayList<AdminLoginDto> loginInfo = adminloginService.getLoginInfo();
            System.out.println(loginInfo);
            AdminLoginDto result = loginInfo.get(0);

            model.addAttribute("img", "/resources/img/test.png");

            if(id.equals(result.getId()) && password.equals(result.getPassword())){
                return "admin";
            }else{
                return "adminLogin";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "adminLogin";
        }
    }




}
