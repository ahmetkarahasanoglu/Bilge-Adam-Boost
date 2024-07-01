package com.ahmet.controllerspring;

import com.ahmet.repository.entity.Tweet;
import com.ahmet.repository.view.VwTweet;
import com.ahmet.service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TwitterRestController {

    private final TweetService tweetService;

    public TwitterRestController() {
        this.tweetService = new TweetService();
    }

    @GetMapping("/findall")
    public ResponseEntity<List<VwTweet>> findAllTweet() {
        return ResponseEntity.ok(tweetService.findAllViewTweet());
    }

}
