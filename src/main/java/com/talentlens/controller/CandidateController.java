
package com.talentlens.controller;

import com.talentlens.entity.Candidate;
import com.talentlens.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public Candidate addCandidate(@Valid @RequestBody Candidate candidate) {
        return candidateService.addCandidate(candidate);
    }

    @GetMapping
    public Page<Candidate> getAllCandidates(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return candidateService.getAllCandidates(
                page, size, sortBy, direction);
    }

    @GetMapping("/search")
    public List<Candidate> searchCandidates(
            @RequestParam String keyword) {
        return candidateService.searchCandidates(keyword);
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(
            @PathVariable Long id,
            @Valid @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/filter")
    public List<Candidate> filterByExperience(
            @RequestParam Integer minExperience) {

        return candidateService.filterByExperience(minExperience);
    }
    @GetMapping("/search/advanced")
    public List<Candidate> searchBySkillsAndExperience(
            @RequestParam String skills,
            @RequestParam Integer minExperience) {

        return candidateService.searchBySkillsAndExperience(
                skills, minExperience
        );
    }
}