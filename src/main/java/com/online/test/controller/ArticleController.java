package com.online.test.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.test.pojo.Article;
import com.online.test.pojo.PageResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author ian
 * @create 05/02/25 15.07
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/posts";



    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<Article>> articles(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) throws Exception {
        try {
            // Fetch all Data from API
            Article[] articlesArray = restTemplate.getForObject(url, Article[].class);

            if (articlesArray == null || articlesArray.length == 0) {
                return ResponseEntity.noContent().build();
            }

            List<Article> articles = Arrays.asList(articlesArray);

            // Calculate paging
            int totalElements = articles.size();
            int totalPages = (int) Math.ceil((double) totalElements / size);
            int startIndex = page * size;
            int endIndex = Math.min(startIndex + size, totalElements);

            // Validate page range
            if (page >= totalPages) {
                return ResponseEntity.badRequest().body(new PageResponse<>(page, size, totalElements, totalPages, Arrays.asList()));
            }


            List<Article> paginatedArticles = IntStream.range(startIndex, endIndex)
                    .mapToObj(articles::get)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new PageResponse<>(page, size, totalElements, totalPages, paginatedArticles));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }


}
