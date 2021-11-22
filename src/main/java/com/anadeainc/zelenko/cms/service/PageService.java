package com.anadeainc.zelenko.cms.service;

import com.anadeainc.zelenko.cms.entity.Page;
import com.anadeainc.zelenko.cms.repository.PageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PageService {

    private final PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public List<Page> findAllByOrderByPriority() {
        return pageRepository.findAllByOrderByPriority();
    }

    public Page add(Page page) {
        Page page1 = new Page("title", "descr", "slug", "label", "h1", "content", LocalDateTime.now(), 2);
        if(page.getH1() == null || page.getH1().equals("")) {
           return pageRepository.save(page1);
        }
       return pageRepository.save(page);
    }

    public Page getById(Long id) {
        Optional<Page> row  = pageRepository.findById(id);
        if (row.isPresent()) {
            return row.get();
        }
        return null;
    }

    public void delete(Long id) {
        pageRepository.deleteById(id);
    }
}
