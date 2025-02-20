package com.online.test.pojo;

import java.util.List;

/**
 * @Author ian
 * @create 06/02/25 10.00
 */
public class PageResponse<T> {

    private int page;
    private int size;
    private int totalElements;
    private int totalPages;
    private List<T> content;

    public PageResponse(int page, int size, int totalElements, int totalPages, List<T> content) {
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
    }

    // Getters
    public int getPage() { return page; }
    public int getSize() { return size; }
    public int getTotalElements() { return totalElements; }
    public int getTotalPages() { return totalPages; }
    public List<T> getContent() { return content; }
}
