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
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SendEmailService sendEmailService;


    public UserController(UserService userService) {

        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
        sendEmailService.sendEmail(user.getUsername(),"Your email is: "+user.getUsername()+"Your password is:  "+"+bCryptPasswordEncoder.encode(user.getPassword()) ", "Password");
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
    public String home(Principal principal, Model model) {
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
