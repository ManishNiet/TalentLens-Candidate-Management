
package com.talentlens.repository;

import java.util.List;
import com.talentlens.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByFullNameContainingIgnoreCaseOrSkillsContainingIgnoreCase(
            String fullName, String skills);
    List<Candidate> findByExperienceYearsGreaterThanEqual(
            Integer minExperience);
    List<Candidate> findBySkillsContainingIgnoreCaseAndExperienceYearsGreaterThanEqual(
            String skills,
            Integer minExperience
    );
}
