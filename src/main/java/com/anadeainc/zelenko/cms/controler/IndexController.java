package com.anadeainc.zelenko.cms.controler;

import com.anadeainc.zelenko.cms.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final PageService pageService;

    public IndexController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("pages", pageService.findAllByOrderByPriority());
        return "index";
    }

    @GetMapping("/create")
    public String createPage(){
        return "create";
    }
}
