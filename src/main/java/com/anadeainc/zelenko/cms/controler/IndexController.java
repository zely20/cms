package com.anadeainc.zelenko.cms.controler;

import com.anadeainc.zelenko.cms.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model){
        model.addAttribute("page", pageService.getById(id));
        return "edit";
    }

    @GetMapping("/content/{id}")
    public String contentPage(@PathVariable Integer id, Model model){
        model.addAttribute("page", pageService.getById(id));
        return "content";
    }
}
