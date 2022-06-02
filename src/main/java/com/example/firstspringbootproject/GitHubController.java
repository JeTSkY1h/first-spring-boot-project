package com.example.firstspringbootproject;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/github")
public class GitHubController {
    
    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/{user}")
    public List<String> getRepos(@PathVariable String user){
       return gitHubService.getRepos(user).stream().map(r->r.getName()).toList();

    }



}
