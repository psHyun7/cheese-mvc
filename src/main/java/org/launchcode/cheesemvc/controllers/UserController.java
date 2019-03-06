package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;



@RequestMapping("user")

@Controller

public class UserController {



    @RequestMapping(method = RequestMethod.GET)

    public String index(){

        return "/user/add";

    }



    @RequestMapping(method = RequestMethod.POST)

    public String add(Model model, @ModelAttribute User user, String verify){





        // the passwords don't match:

        if(!user.getPassword().equals(verify)){

            model.addAttribute("verify_password_error", "The passwords do not match");

        }



        model.addAttribute("user_name", user.getUsername());

        model.addAttribute("user_greeting", "Hello, " + user.getUsername());



        return "/user/index";



    }



}