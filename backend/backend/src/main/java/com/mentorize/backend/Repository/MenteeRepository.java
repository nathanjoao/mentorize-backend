package com.mentorize.backend.Repository;

import com.mentorize.backend.Model.Entity.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenteeRepository extends JpaRepository<Mentee, Integer> {
}
