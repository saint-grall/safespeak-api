package com.safespeak.demo.controller;

import com.safespeak.demo.model.Story;
import com.safespeak.demo.service.ReplyService;
import com.safespeak.demo.model.Reply;

import com.safespeak.demo.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/all")
    public List<Reply> getAllReplies() {
        return replyService.getAllReplies();
    }

    @PostMapping("/create")
    public Reply createReply(@RequestBody Reply reply) {
        return replyService.createReply(reply);
    }

    @PutMapping("/{id}/update")
    public Reply updateReply(@RequestBody Reply reply, @PathVariable long id) {
        return replyService.updateReply(id, reply);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteReply(@PathVariable long id) {
        replyService.deleteReply(id);
    }
}
