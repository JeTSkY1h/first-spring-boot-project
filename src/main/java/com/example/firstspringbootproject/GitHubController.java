package com.example.firstspringbootproject;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/github")
public class GitHubController {
    
    @GetMapping("/{user}")
    public List<String> getRepos(@PathVariable String user){
        RestTemplate restTemplate = new RestTemplate();
        
        
        return Arrays.stream(restTemplate.getForObject("https://api.github.com/users/" + user + "/repos", Repos[].class))
                .map(r -> r.getName()).toList();

    }



}
