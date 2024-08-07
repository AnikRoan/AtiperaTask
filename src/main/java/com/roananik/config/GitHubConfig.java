package com.roananik.config;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GitHubConfig {
    @Bean
    public GitHub gitHub() throws IOException {
        return new GitHubBuilder().build();
    }
}
