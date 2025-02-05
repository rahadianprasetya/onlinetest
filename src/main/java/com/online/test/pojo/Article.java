package com.online.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author ian
 * @create 05/02/25 17.34
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
