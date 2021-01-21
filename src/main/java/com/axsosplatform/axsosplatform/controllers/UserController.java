package com.axsosplatform.axsosplatform.controllers;

import com.axsosplatform.axsosplatform.models.User;
import com.axsosplatform.axsosplatform.services.SendEmailService;
import com.axsosplatform.axsosplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;


@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }

    @PostMapping("/registration")
    public String registration( @ModelAttribute("user") User user, Model model, HttpSession session) {



        userService.saveWithUserRole(user);
        return "redirect:/login";
    }


    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model,HttpSession session) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }


    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public String adminPage(Principal principal, Model model ,@ModelAttribute("user") User user) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));

        return "adminPage.jsp";
    }




}
