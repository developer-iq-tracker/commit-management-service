package com.developeriqtracker.commitmanagementservice.dto;

import com.developeriqtracker.commitmanagementservice.model.Commit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommitDetailsDto {

    private int commitCount;
    private List<Commit> commits;
}
