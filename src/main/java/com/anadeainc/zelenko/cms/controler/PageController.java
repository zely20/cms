package com.anadeainc.zelenko.cms.controler;

import com.anadeainc.zelenko.cms.entity.Page;
import com.anadeainc.zelenko.cms.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
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

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        pageService.delete(id);
    }

    @GetMapping("{id}")
    public Page getById(@PathVariable Long id) {
        return pageService.getById(id);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Page create(@RequestBody Page page) {
        System.out.println("create");
        return pageService.add(page);
    }
}
