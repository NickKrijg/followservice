package com.kwetter.followservice.controllers;

import com.kwetter.followservice.entity.Follow;
import com.kwetter.followservice.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
@CrossOrigin(origins = {"http://localhost:8080", "*"})
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> follow(@PathVariable("username") String username){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Follow follow = new Follow(userDetails.getUsername(), username);
        followService.saveFollow(follow);

        return ResponseEntity.ok("Started following: " + username);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> unFollow(@PathVariable("username") String username) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Follow follow = new Follow(userDetails.getUsername(), username);
        followService.deleteFollow(follow);
        return ResponseEntity.ok("Stopped following: " + username);
    }

    @GetMapping("/mysimps")
    public ResponseEntity<Iterable<Follow>> getMySimps() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Iterable<Follow> mySimps = followService.getMySimps(userDetails.getUsername());
        return ResponseEntity.ok(mySimps);
    }

    @GetMapping("/myfollows")
    public ResponseEntity<Iterable<Follow>> getMyFollows() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Iterable<Follow> myFollows = followService.getFollows(userDetails.getUsername());
        return ResponseEntity.ok(myFollows);
    }
}
