package com.anadeainc.zelenko.cms.service;

import com.anadeainc.zelenko.cms.entity.Page;
import com.anadeainc.zelenko.cms.repository.PageRepository;
import org.springframework.stereotype.Service;

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
        return pageRepository.save(page);
    }

    public Page getById(Integer id) {
        Optional<Page> row = pageRepository.findById(id);
        if (row.isPresent()) {
            return row.get();
        }
        return null;
    }

    public void delete(Integer id) {
        pageRepository.deleteById(id);
    }
}
