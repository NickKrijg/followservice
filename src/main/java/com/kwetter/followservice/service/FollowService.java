package com.kwetter.followservice.service;

import com.kwetter.followservice.entity.Follow;
import com.kwetter.followservice.Repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FollowService {

    @Autowired
    FollowRepository followRepository;

    public void saveFollow(Follow follow){
        followRepository.save(follow);
    }

    public void deleteFollow(Follow follow) {
        followRepository.delete(follow);
    }

    public Iterable<Follow> getFollows(String simp) {
        return followRepository.getAllBySimp(simp);
    }

    public Iterable<Follow> getMySimps(String simp) {
        return followRepository.getAllByFollows(simp);
    }

    @Transactional
    public Integer deleteAllByUsername(String username) {
        Integer follows = followRepository.deleteAllByFollows(username);
        Integer simps = followRepository.deleteAllBySimp(username);
        return follows + simps;
    }
}
