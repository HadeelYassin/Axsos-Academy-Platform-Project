package com.axsosplatform.axsosplatform.controllers;


import com.axsosplatform.axsosplatform.models.QuestionPost;
import com.axsosplatform.axsosplatform.models.Tag;
import com.axsosplatform.axsosplatform.services.QuestionPostService;
import com.axsosplatform.axsosplatform.services.TagService;
import com.axsosplatform.axsosplatform.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.function.BinaryOperator;

@Controller
public class PostController {
    private final QuestionPostService questionPostService;
    private final TagService tagService;
    private final UserService userService;

    public PostController(QuestionPostService questionPostService, TagService tagService, UserService userService) {
        this.questionPostService = questionPostService;
        this.tagService = tagService;
        this.userService = userService;
    }

    @RequestMapping("tag/{id}/post")
    public String showPosts(@PathVariable("id") Long id, Model model) {
        List<QuestionPost> allTagPosts = tagService.getquestions(id, "post");
        model.addAttribute("allPosts", allTagPosts);
        return "tagPosts.jsp";
    }




}
