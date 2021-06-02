package com.kwetter.followservice.Repository;

import com.kwetter.followservice.entity.Follow;
import com.kwetter.followservice.entity.FollowId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends CrudRepository<Follow, FollowId> {
    Iterable<Follow> getAllBySimp(String simp);
    Iterable<Follow> getAllByFollows(String simp);

    Integer deleteAllByFollows(String username);
    Integer deleteAllBySimp(String username);
}
