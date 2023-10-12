package com.safespeak.demo.repository;

import com.safespeak.demo.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {

}
