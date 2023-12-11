package com.developeriqtracker.commitmanagementservice.controller;

import com.developeriqtracker.commitmanagementservice.dto.CommitDetailsDto;
import com.developeriqtracker.commitmanagementservice.model.Commit;
import com.developeriqtracker.commitmanagementservice.service.CommitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/commit")
public class CommitController {

    private CommitService commitService;

    @GetMapping("/sync-from-git-hub")
    public ResponseEntity<List<Commit>> syncCommitDetailsFromGithub() {
        return ResponseEntity.ok(this.commitService.syncCommitDetailsFromGithub());
    }

    @GetMapping("/get-by-user")
    public ResponseEntity<CommitDetailsDto> getAllCommitByUser(@RequestParam String userName) {
        return ResponseEntity.ok(this.commitService.getAllCommitByUser(userName));
    }
}
