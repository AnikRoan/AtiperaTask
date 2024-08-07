package com.roananik.controller;

import com.roananik.pojo.RepositoryName;
import com.roananik.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.kohsuke.github.GHFileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/github")
public class GitHubController {
    private final GitHubService gitHubService;


    @GetMapping("/repositories/{name}")
    public ResponseEntity<List<RepositoryName>> getRepositories(@PathVariable("name") String name,
                                                                @RequestHeader("Accept") String acceptHeader) throws GHFileNotFoundException {
        if (!"application/json".equals(acceptHeader)) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.ok().body(gitHubService.getRepositories(name));
    }
}
