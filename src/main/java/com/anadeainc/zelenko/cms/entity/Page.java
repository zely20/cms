package com.anadeainc.zelenko.cms.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "pages")
@Data
public class Page{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String slug;
    @Column(name = "menu_label")
    private String menuLabel;
    private String h1;
    private String content;
    @Column(name = "published_at")
    private LocalDateTime publishedAt;
    private Integer priority;

    public Page() {
    }

    public Page(String title, String description, String slug, String menuLabel, String h1, String content, LocalDateTime publishedAt, Integer priority) {
        this.title = title;
        this.description = description;
        this.slug = slug;
        this.menuLabel = menuLabel;
        this.h1 = h1;
        this.content = content;
        this.publishedAt = publishedAt;
        this.priority = priority;
    }
}
