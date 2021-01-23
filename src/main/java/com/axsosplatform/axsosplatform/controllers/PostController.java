package com.axsosplatform.axsosplatform.controllers;


import com.axsosplatform.axsosplatform.models.Comment;
import com.axsosplatform.axsosplatform.models.QuestionPost;
import com.axsosplatform.axsosplatform.models.Tag;
import com.axsosplatform.axsosplatform.models.TypeO;
import com.axsosplatform.axsosplatform.services.QuestionPostService;
import com.axsosplatform.axsosplatform.services.TagService;
import com.axsosplatform.axsosplatform.services.TypeService;
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

@Controller
public class PostController {
    private final QuestionPostService questionPostService;
    private final TagService tagService;
    private final UserService userService;
    private final TypeService typeService;

    public PostController(QuestionPostService questionPostService, TagService tagService, UserService userService, TypeService typeService) {
        this.questionPostService = questionPostService;
        this.tagService = tagService;
        this.userService = userService;
        this.typeService = typeService;
    }

//    @RequestMapping("tag/{id}/posts")
//    public String showPosts(@PathVariable("id") Long id, Model model) {
//        List<QuestionPost> allTagPosts = tagService.getquestions(id, "post");
//        model.addAttribute("allPosts", allTagPosts);
//        return "tagPosts.jsp";
//    }

    @RequestMapping("/addPost")
    public String showAddPostForm(@ModelAttribute("post") QuestionPost post, Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        TypeO kind=typeService.findType("post");
        List<Tag> tags =tagService.findAllTag();
        model.addAttribute("tags",tags);
        model.addAttribute("kind",kind);
        return "addPost.jsp";
    }
    @PostMapping("/addPost")
    public String addPost(@Valid @ModelAttribute("post") QuestionPost post, BindingResult result){
        if(result.hasErrors()){
            return "addPost.jsp";
        }
        questionPostService.addYourQuestionPost(post);
        return "redirect:/post/"+post.getId();
    }

    @RequestMapping("/post/{id}")
    public String showPost(@PathVariable("id") Long id, Model model, @ModelAttribute("comment") Comment comment){
        QuestionPost post=questionPostService.getQuestionPostById(id);
        if (post ==null){
            return "error.jsp";
        }else {
            model.addAttribute("post",post);
            return "showQuestionPost.jsp";
        }

    }


}
