package com.anadeainc.zelenko.cms.controler;

import com.anadeainc.zelenko.cms.entity.Page;
import com.anadeainc.zelenko.cms.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private final PageService pageService;

    public IndexController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        List<Page> pagesFromBd = pageService.findAllByOrderByPriority();
        List<Page> pages = new ArrayList<>();
        List<Page> unpublishedPages = new ArrayList<>();
        for (Page page : pagesFromBd) {
            if (page.getPublishedAt() != null) {
                if (page.getPublishedAt().isBefore(LocalDate.now()) || page.getPublishedAt().isEqual(LocalDate.now())) {
                    pages.add(page);
                } else {
                    unpublishedPages.add(page);
                }
            }
        }
        model.addAttribute("pages", pages);
        model.addAttribute("unpublishedPages", unpublishedPages);
        return "index";
    }

    @GetMapping("/create")
    public String createPage() {
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        model.addAttribute("page", pageService.getById(id));
        return "edit";
    }

    @GetMapping("/content/{id}")
    public String contentPage(@PathVariable Integer id, Model model) {
        model.addAttribute("page", pageService.getById(id));
        return "content";
    }
}
