package com.example.firstspringbootproject;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
 
    List<Repos>getRepos(String user){
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream(restTemplate.getForObject("https://api.github.com/users/" + user + "/repos", Repos[].class))
                .map(r -> r).toList();
    }

}