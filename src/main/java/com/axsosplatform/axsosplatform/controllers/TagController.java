package com.axsosplatform.axsosplatform.controllers;

import com.axsosplatform.axsosplatform.models.Tag;
import com.axsosplatform.axsosplatform.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }



}
