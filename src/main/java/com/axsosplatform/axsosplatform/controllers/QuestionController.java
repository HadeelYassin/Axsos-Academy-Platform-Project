package com.axsosplatform.axsosplatform.controllers;

import com.axsosplatform.axsosplatform.models.QuestionPost;
import com.axsosplatform.axsosplatform.models.Tag;
import com.axsosplatform.axsosplatform.models.Type;
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
public class QuestionController {
    private  final QuestionPostService questionPostService;
    private final TagService tagService;
    private final UserService userService;
    private final TypeService typeService;

    public QuestionController(QuestionPostService questionPostService, TagService tagService, UserService userService, TypeService typeService) {
        this.questionPostService = questionPostService;
        this.tagService = tagService;
        this.userService = userService;
        this.typeService = typeService;
    }




    @RequestMapping("tag/{id}/question")
    public String showQuestions(@PathVariable("id") Long id, Model model, @ModelAttribute("posts") QuestionPost posts){
        List <QuestionPost> allTagQuestions=tagService.getquestions(id,"question");
        model.addAttribute("allPosts",allTagQuestions);
        return "tagPosts.jsp";
    }
    @RequestMapping("/askQuestion")
    public String showAskQuestionForm(@ModelAttribute("question") QuestionPost question, Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        Type kind=typeService.findType("question");
        List<Tag> tags =tagService.findAllTag();
        model.addAttribute("tags",tags);
        model.addAttribute("kind",kind);
        return "askQuestion.jsp";
    }

    @PostMapping("/askQuestion")
    public String askQuestion(@Valid @ModelAttribute("question") QuestionPost question, BindingResult result){
        if(result.hasErrors()){
            return "askQuestion.jsp";
        }
        questionPostService.addYourQuestionPost(question);
        return "redirect:/question/"+question.getId();
    }
    @RequestMapping("/question/{id}")
    public String showQuestion(@PathVariable("id") Long id, Model model){
        QuestionPost question=questionPostService.getQuestionPostById(id);
        if (question ==null){
            return "error.jsp";
        }else {
            model.addAttribute("question",question);
            return "redirect:/askQuestion";
        }

    }
    @RequestMapping("/search")
    public String searchResults(Model model){
        List<QuestionPost> reslutQuestion=questionPostService.findsearchResult("nn","nn");
        model.addAttribute("allreslut",reslutQuestion);
        return "result.jsp";
    }


}
