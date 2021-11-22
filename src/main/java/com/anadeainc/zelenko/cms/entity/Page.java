package com.anadeainc.zelenko.cms.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "pages")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return Objects.equals(id, page.id) &&
                Objects.equals(title, page.title) &&
                Objects.equals(description, page.description) &&
                Objects.equals(slug, page.slug) &&
                Objects.equals(menuLabel, page.menuLabel) &&
                Objects.equals(h1, page.h1) &&
                Objects.equals(content, page.content) &&
                Objects.equals(publishedAt, page.publishedAt) &&
                Objects.equals(priority, page.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, slug, menuLabel, h1, content, publishedAt, priority);
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", slug='" + slug + '\'' +
                ", menuLabel='" + menuLabel + '\'' +
                ", h1='" + h1 + '\'' +
                ", content='" + content + '\'' +
                ", publishedAt=" + publishedAt +
                ", priority=" + priority +
                '}';
    }
}
