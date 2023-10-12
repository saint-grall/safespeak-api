package com.safespeak.demo.service;

import com.safespeak.demo.exceptions.StoryNotFoundException;
import com.safespeak.demo.model.Story;
import com.safespeak.demo.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StoryService {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    public List<Story> getRandomStories(int numberOfStories) {
        List<Story> allStories = storyRepository.findAll();
        Collections.shuffle(allStories);

        return allStories.subList(0, Math.min(numberOfStories, allStories.size()));
    }

    public Story getStoryById(Long id) {
        Optional<Story> storyOpt = storyRepository.findById(id);
        return storyOpt.orElse(null);
    }

    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    public Story updateStory(Long id, Story updatedStory) {
        try {
            return storyRepository.save(updatedStory);
        } catch (Exception e){
            throw new StoryNotFoundException("Story with id " + id + " not found" + e);
        }
    }


    public void deleteStory(Long id) {
        storyRepository.deleteById(id);
    }
}
