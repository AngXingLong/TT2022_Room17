package com.example.demo.techtrek;


import com.example.demo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Arrays;

@Component
public class TechtrekClient {

    private String baseUrl = "http://localhost:5000";
    private static RestTemplate restTemplate;

    public TechtrekClient(){
        restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    }


    public User getUser(Long id){
        return restTemplate.getForObject("/user/1", User.class);
    }

    public User insertUser(){

        /*
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("id", "1");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("/form", request , String.class);
        */
        User user = new User();
        user.setUsername("test");
        user.setActive(true);
        user.setPassword("tset");
        user.setRoles("test");

        HttpEntity<User> request = new HttpEntity<>(user);
        return restTemplate.postForObject("user", request, User.class);
    }


}
