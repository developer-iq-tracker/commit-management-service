package com.developeriqtracker.commitmanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "commit")
public class Commit {

    @Id
    private String id;

    private String gitHubId;

    private String author;

    private String commitMessage;
}
