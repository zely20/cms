package com.anadeainc.zelenko.cms.controler;

import com.anadeainc.zelenko.cms.entity.Page;
import com.anadeainc.zelenko.cms.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("pages")
public class PageController {

    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public List<Page> findAllByOrderByPriority() {
        return pageService.findAllByOrderByPriority();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pageService.delete(id);
        return "redirect:/index";
    }

    @PostMapping("/edit")
    public String editPage(@ModelAttribute Page page){
        Page pageFromBd = pageService.getById(page.getId());
        pageFromBd.setTitle(page.getTitle());
        pageFromBd.setDescription(page.getDescription());
        pageFromBd.setSlug(page.getSlug());
        pageFromBd.setMenuLabel(page.getMenuLabel());
        pageFromBd.setH1(page.getH1());
        pageFromBd.setContent(page.getContent());
        pageFromBd.setPublishedAt(page.getPublishedAt());
        pageFromBd.setPriority(page.getPriority());
        pageService.add(pageFromBd);
        return "redirect:/index";
    }

    @GetMapping("{id}")
    public Page getById(@PathVariable Integer id) {
        return pageService.getById(id);
    }

    @PostMapping("/save")
    public String createPost(@ModelAttribute Page page) {
        pageService.add(page);
        return "redirect:/index";
    }
}
