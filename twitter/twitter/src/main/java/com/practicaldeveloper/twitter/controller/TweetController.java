package com.practicaldeveloper.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practicaldeveloper.twitter.dto.TweetDto;
import com.practicaldeveloper.twitter.service.TweetService;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    // Create operation
    @PostMapping
    public ResponseEntity<TweetDto> createTweet(@RequestBody TweetDto tweetDTO) {
        TweetDto createdTweet = tweetService.saveTweet(tweetDTO);
        return new ResponseEntity<>(createdTweet, HttpStatus.CREATED);
    }

//    // Read operation
//    @GetMapping("/{tweetId}")
//    public ResponseEntity<TweetDto> getTweetById(@PathVariable int tweetId) {
//        TweetDto tweetDTO = tweetService.getTweetById(tweetId);
//        return ResponseEntity.ok(tweetDTO);
//    }

    // Update operation
    @PutMapping("/{tweetId}")
    public ResponseEntity<TweetDto> updateTweet(@PathVariable int tweetId, @RequestBody TweetDto updatedTweetDTO) {
        TweetDto updatedTweet = tweetService.updateTweet(tweetId, updatedTweetDTO);
        return ResponseEntity.ok(updatedTweet);
    }

    // Delete operation
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@PathVariable int tweetId) {
        tweetService.deleteTweet(tweetId);
        return ResponseEntity.noContent().build();
    }

//    // Get all tweets
//    @GetMapping
//    public ResponseEntity<List<TweetDto>> getAllTweets() {
//        List<TweetDto> tweetDTOList = tweetService.getAllTweets();
//        return ResponseEntity.ok(tweetDTOList);
//    }
//    
    @GetMapping("/{email}")
    public ResponseEntity<List<TweetDto>> getAllTweetsByEmail(@PathVariable String email) {
        List<TweetDto> tweetDTOList = tweetService.findByEmail(email);
        return ResponseEntity.ok(tweetDTOList);
    }
    
}

