package com.developeriqtracker.commitmanagementservice.service;

import com.developeriqtracker.commitmanagementservice.dto.CommitDetailsDto;
import com.developeriqtracker.commitmanagementservice.dto.CommitDto;
import com.developeriqtracker.commitmanagementservice.model.Commit;
import com.developeriqtracker.commitmanagementservice.repository.CommitRepository;
import com.developeriqtracker.commitmanagementservice.service.external.GithubExternalClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CommitServiceImpl implements CommitService {

    private final GithubExternalClientService githubExternalClientService;
    private final CommitRepository commitRepository;

    @Override
    public List<Commit> syncCommitDetailsFromGithub() {
        List<Commit> commits = new ArrayList<>();
        log.info("sync Commit Details From Github | process Started");
        List<CommitDto> commitDtoList = this.githubExternalClientService.getContributorDetails();

        commitDtoList.forEach(commitDto -> {
            if (commitDto.getCommitDataDto() != null) {
                Commit commit = this.generateGitHubUserObject(commitDto);
                log.info("sync Commit Details From Github  | save new record | {}", commit);
                this.checkAndRemoveOldRecords(commit);
                commits.add(commit);
            }
        });

        this.commitRepository.saveAll(commits);
        log.info("sync Commit Details From Github  | process end");
        return commits;

    }

    @Override
    public CommitDetailsDto getAllCommitByUser(String userName) {
        List<Commit> commits = this.commitRepository.findAllByAssignee(userName);
        return CommitDetailsDto.builder().commitCount(commits.size()).commits(commits).build();
    }

    private void checkAndRemoveOldRecords(Commit commit) {
        Optional<Commit> oldCommit = this.commitRepository.findByGitHubId(commit.getGitHubId());
        oldCommit.ifPresent(this.commitRepository::delete);
    }

    private Commit generateGitHubUserObject(CommitDto commitDto) {
        return Commit.builder()
                .gitHubId(commitDto.getGitHubId())
                .author(commitDto.getAuthor().getLogin())
                .commitMessage(commitDto.getCommitDataDto().getCommitMessage())
                .build();
    }
}