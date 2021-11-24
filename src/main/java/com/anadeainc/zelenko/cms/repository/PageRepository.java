package com.anadeainc.zelenko.cms.repository;

import com.anadeainc.zelenko.cms.entity.Page;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PageRepository extends CrudRepository<Page, Integer> {
    List<Page> findAllByOrderByPriority();
}
