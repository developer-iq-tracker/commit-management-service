package com.developeriqtracker.commitmanagementservice.service;


import com.developeriqtracker.commitmanagementservice.dto.CommitDetailsDto;
import com.developeriqtracker.commitmanagementservice.model.Commit;

import java.util.List;

public interface CommitService {


    List<Commit> syncCommitDetailsFromGithub();

    CommitDetailsDto getAllCommitByUser(String userName);
}
