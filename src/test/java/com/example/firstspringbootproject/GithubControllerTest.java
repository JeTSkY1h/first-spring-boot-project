package com.example.firstspringbootproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GithubControllerTest {
    
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test 
    void shouldReturnRepos() {
        
       ResponseEntity<String[]> res = restTemplate.getForEntity("/github/JeTSkY1h", String[].class);

       assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
       assertThat(res.getBody().length).isEqualTo(6);
    }
}