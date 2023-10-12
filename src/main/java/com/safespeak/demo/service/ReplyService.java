package com.safespeak.demo.service;

import com.safespeak.demo.exceptions.ReplyNotFoundException;
import com.safespeak.demo.exceptions.StoryNotFoundException;
import com.safespeak.demo.model.Reply;
import com.safespeak.demo.model.Story;
import com.safespeak.demo.repository.ReplyRepository;

import com.safespeak.demo.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {
    @Autowired
    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    public Reply getReplyById(Long id) {
        Optional<Reply> replyOpt = replyRepository.findById(id);
        return replyOpt.orElse(null);
    }

    public Reply createReply(Reply reply) {
        return replyRepository.save(reply);
    }

    public Reply updateReply(Long id, Reply updatedReply) {
        Optional<Reply> existingReplyOpt = replyRepository.findById(id);

        if (existingReplyOpt.isPresent()) {
            Reply existingReply = existingReplyOpt.get();
            existingReply.setStory(updatedReply.getStory());
            existingReply.setAnswers(updatedReply.getAnswers());

            return replyRepository.save(existingReply);
        } else {
            throw new ReplyNotFoundException("Story with id " + id + " not found");
        }
    }

    public void deleteReply(Long id) {
        replyRepository.deleteById(id);
    }
}
