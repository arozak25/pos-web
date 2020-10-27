package com.web2.pos.controller;

import com.web2.pos.model.web.LoginWebRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Abdul Rozak
 * @since 10/27/20
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginMessage(Model model){
        model.addAttribute("loginWebRequest", new LoginWebRequest());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute LoginWebRequest loginWebRequest, Model model) {
        model.addAttribute("loginWebRequest", loginWebRequest);
        return "home";
    }

}
