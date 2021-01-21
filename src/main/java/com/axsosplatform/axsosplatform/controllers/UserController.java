package com.axsosplatform.axsosplatform.controllers;

import com.axsosplatform.axsosplatform.models.Tag;
import com.axsosplatform.axsosplatform.models.User;
import com.axsosplatform.axsosplatform.services.TagService;
import com.axsosplatform.axsosplatform.services.UserService;
import com.axsosplatform.axsosplatform.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class UserController {
    private final UserService userService;
    private final  TagService tagService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator,TagService tagService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.tagService = tagService;
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

    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model, @Valid @ModelAttribute("user") User user, @ModelAttribute("tag") Tag tag) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        List<User> alluser= userService.findAllUser();
        model.addAttribute("users",alluser);
        return "adminPage.jsp";
    }


    @PostMapping("/admin")
    public String registration( @RequestParam("UserTag") String userTag,@Valid @ModelAttribute("user") User user,BindingResult result, Model model,@Valid @ModelAttribute("tag") Tag tag, BindingResult resultTag) {
        userValidator.validate(user, result);
        if (userTag.equals("user1")) {
            if (result.hasErrors()) {
                System.out.println("*********");
                return "adminPage.jsp";
            }
            userService.saveWithUserRole(user);
        }
        else {
            if(resultTag.hasErrors()){
                return "adminPage.jsp";
            }
            tagService.addTag(tag);
        }


        return "redirect:/admin";
    }



}


