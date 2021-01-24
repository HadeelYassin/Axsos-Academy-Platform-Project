package com.axsosplatform.axsosplatform.controllers;

import com.axsosplatform.axsosplatform.models.Comment;
import com.axsosplatform.axsosplatform.models.QuestionPost;
import com.axsosplatform.axsosplatform.models.Tag;
import com.axsosplatform.axsosplatform.models.TypeO;
import com.axsosplatform.axsosplatform.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
    private  final QuestionPostService questionPostService;
    private final TagService tagService;
    private final UserService userService;
    private final TypeService typeService;
    private final CommentService commentService;

    public QuestionController(QuestionPostService questionPostService, TagService tagService, UserService userService, TypeService typeService, CommentService commentService) {
        this.questionPostService = questionPostService;
        this.tagService = tagService;
        this.userService = userService;
        this.typeService = typeService;
        this.commentService = commentService;
    }




    @RequestMapping("tag/{id}/questions")
    public String showQuestions(@PathVariable("id") Long id, Model model,Principal principal){
        System.out.println("before query");
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        List <Object[]> allQuestions=tagService.getquestions(id,"question");
        System.out.println("after query");
        Tag tag =tagService.findTagById(id);
        List<QuestionPost> all=new ArrayList<QuestionPost>();

        System.out.println(all.size());
        BigInteger b;
        long questionId;
        for (int i = 0; i <allQuestions.size() ; i++) {
            b= new BigInteger(allQuestions.get(i)[0].toString());
            questionId=b.longValue();
            all.add(new QuestionPost(questionId,(String)allQuestions.get(i)[1],(String)allQuestions.get(i)[3]));
         }


        model.addAttribute("allquestions",all);
        model.addAttribute("t",tag);
        return "questions.jsp";
    }

    @RequestMapping("/askQuestion")
    public String showAskQuestionForm(@ModelAttribute("question") QuestionPost question, Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        TypeO kind=typeService.findType("question");
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
        return "redirect:/";
    }

    @RequestMapping("/tag/{tid}/question/{id}")
    public String showQuestion(@PathVariable("tid") Long tid,@PathVariable("id") Long id, Model model, @ModelAttribute("commentoo")Comment comment,Principal principal){
        QuestionPost question=questionPostService.getQuestionPostById(id);
        String username = principal.getName();
        Tag tag =tagService.findTagById(tid);
        model.addAttribute("tag", tag);
        model.addAttribute("currentUser", userService.findByUsername(username));
        if (question ==null){
            return "error.jsp";
        }else {
            model.addAttribute("question",question);
            return "showQuestionPost.jsp";
        }

    }
    @PostMapping("/tag/{tid}/question/{id}")
    public String addComment(@ModelAttribute("commentoo")Comment comment,@PathVariable("tid") Long tid, @PathVariable("id") long qid){
        QuestionPost questionPost=questionPostService.getQuestionPostById(qid);
        System.out.println("after get question");
        Tag tag=tagService.findTagById(tid);
        System.out.println("after get tag");

        commentService.addComment(comment);
        System.out.println("after create comment");

        return "redirect:/tag/"+tag.getId()+"/question/"+questionPost.getId();

    }

    @RequestMapping("/search")
    public String searchResults(Model model , @PathParam("se") String se){
        List<QuestionPost> reslutQuestion=questionPostService.findsearchResult(se,se);
        model.addAttribute("allreslut",reslutQuestion);
        return "result.jsp";
    }

}
