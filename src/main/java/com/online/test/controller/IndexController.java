package com.online.test.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.test.pojo.Article;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author ian
 * @create 05/02/25 15.07
 */
@RestController
@RequestMapping("/")
public class IndexController {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/posts";
    String result = restTemplate.getForObject(url,String.class);


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> getConnected() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Article> articles = objectMapper.readValue(result, new TypeReference<List<Article>>() {});
        return ResponseEntity.ok().body(articles);
    }


}
