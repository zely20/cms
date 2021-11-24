package com.anadeainc.zelenko.cms.controler;

import com.anadeainc.zelenko.cms.entity.Page;
import com.anadeainc.zelenko.cms.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("pages")
public class PageController {

    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Page> findAllByOrderByPriority() {
        return pageService.findAllByOrderByPriority();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println(id);
        pageService.delete(id);
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
