package com.web2.pos.controller;

import com.web2.pos.model.web.WebResponse;
import com.web2.pos.model.web.request.LoginForm;
import com.web2.pos.model.web.response.LoginWebResponse;
import com.web2.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author Abdul Rozak
 * @since 10/27/20
 */
@Controller
public class LoginController implements WebMvcConfigurer {

    @Autowired
    private UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("argon-dashboard-master/index");
    }

    @GetMapping("/login")
    public String login(HttpSession session, Model model){
        String username = (String) session.getAttribute("USERNAME");

        if (username != null)
            return "redirect:/home";

        model.addAttribute("loginForm", new LoginForm());
        return "argon-dashboard-master/examples/login";
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute LoginForm loginForm,
            BindingResult bindingResult,
            HttpServletRequest request,
            Model model
    ) {
        if (bindingResult.hasErrors())
            return "argon-dashboard-master/examples/login";

        LoginWebResponse loginResponse = userService.login(loginForm);

        model.addAttribute("webResponse", WebResponse.<LoginWebResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.name())
                .data(loginResponse)
                .build()
        );

        request.getSession().setAttribute("USERNAME", loginResponse.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, LoginForm loginForm, BindingResult bindingResult) {
        request.getSession().invalidate();

        return "argon-dashboard-master/examples/login";
    }

}
