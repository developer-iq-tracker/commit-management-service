package com.developeriqtracker.commitmanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitDto {

    @JsonProperty("sha")
    private String gitHubId;
    @JsonProperty("commit")
    private CommitDataDto commitDataDto;
    @JsonProperty("author")
    private Author author;

}
