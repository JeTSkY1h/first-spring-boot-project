package com.example.firstspringbootproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GithubControllerTest {
    Repos mockRepo1 = new Repos("tolles Repo");
    Repos mockRepo2 = new Repos("Karte zum Bernsteinzimmer");

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate = new TestRestTemplate();

    @MockBean
    GitHubService gitHubService;

    @Test 
    void shouldReturnRepos() {
        
        when(gitHubService.getRepos("JeTSkY1h"))
            .thenReturn(List.of(mockRepo1, mockRepo2));
       
        ResponseEntity<String[]> res = restTemplate.getForEntity("/github/JeTSkY1h", String[].class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getBody()).containsExactlyInAnyOrder(mockRepo1.getName(), mockRepo2.getName());
    }
}