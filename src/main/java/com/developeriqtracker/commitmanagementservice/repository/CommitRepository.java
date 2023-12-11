package com.developeriqtracker.commitmanagementservice.repository;

import com.developeriqtracker.commitmanagementservice.model.Commit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommitRepository extends MongoRepository<Commit, String> {
    Optional<Commit> findByGitHubId(String gitHubId);

    List<Commit> findAllByAssignee(String assignee);
}
