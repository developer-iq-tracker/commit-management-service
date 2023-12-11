package com.developeriqtracker.commitmanagementservice.service.external;

import com.developeriqtracker.commitmanagementservice.configuration.properties.GitHubClientProperties;
import com.developeriqtracker.commitmanagementservice.dto.CommitDto;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class GithubExternalClientService {

    private final RestTemplate restTemplate;
    private final GitHubClientProperties clientProperties;

    public List<CommitDto> getContributorDetails() {
        ResponseEntity<List<CommitDto>> response = restTemplate.exchange(clientProperties.getCommitDetailUrl(), HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }


}
