package com.safespeak.demo.controller;

import com.safespeak.demo.service.StoryService;
import com.safespeak.demo.model.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    @Autowired
    private StoryService storyService;

    @GetMapping("/all")
    public List<Story> getAllStories() {
        return storyService.getAllStories();
    }

    @GetMapping("/random")
    public List<Story> getRandomStories() {
        return storyService.getRandomStories(5);
    }

    @PostMapping("/create")
    public Story createStory(@RequestBody Story story) {
        return storyService.createStory(story);
    }

    @PutMapping("/{id}/update")
    public Story updateStory(@RequestBody Story story, @PathVariable long id) {
        return storyService.updateStory(id, story);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteStory(@PathVariable long id) {
        storyService.deleteStory(id);
    }
}
