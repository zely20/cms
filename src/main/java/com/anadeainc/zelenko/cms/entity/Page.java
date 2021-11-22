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
    private Integer id;
    private String title;
    private String description;
    private String slug;
    private String menuLabel;
    private String h1;
    private String content;
    private LocalDateTime publishedAt;
    private Integer priority;
}
