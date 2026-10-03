
package com.talentlens.service;

import com.talentlens.entity.Candidate;
import com.talentlens.repository.CandidateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public List<Candidate> searchBySkillsAndExperience(
            String skills, Integer minExperience) {

        return candidateRepository
                .findBySkillsContainingIgnoreCaseAndExperienceYearsGreaterThanEqual(
                        skills, minExperience
                );
    }
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    // Get candidates with pagination and sorting
    public Page<Candidate> getAllCandidates(
            int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        PageRequest pageable = PageRequest.of(page, size, sort);

        return candidateRepository.findAll(pageable);
    }

    // Create candidate
    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    // Get all candidates
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // Get candidate by ID
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Candidate not found"
                ));
    }

    // Update candidate
    public Candidate updateCandidate(Long id, Candidate candidate) {
        Candidate existing = getCandidateById(id);

        existing.setFullName(candidate.getFullName());
        existing.setEmail(candidate.getEmail());
        existing.setSkills(candidate.getSkills());
        existing.setExperienceYears(candidate.getExperienceYears());

        return candidateRepository.save(existing);
    }

    // Delete candidate
    public void deleteCandidate(Long id) {
        Candidate existing = getCandidateById(id);
        candidateRepository.delete(existing);
    }
    // Search candidates by name or skills
    public List<Candidate> searchCandidates(String keyword) {
        return candidateRepository
                .findByFullNameContainingIgnoreCaseOrSkillsContainingIgnoreCase(
                        keyword, keyword);
    }
    // Filter candidates by minimum experience
    public List<Candidate> filterByExperience(Integer minExperience) {
        return candidateRepository
                .findByExperienceYearsGreaterThanEqual(minExperience);
    }
}