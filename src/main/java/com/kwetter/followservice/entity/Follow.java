package com.kwetter.followservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(FollowId.class)
public class Follow {

    @Id
    private String simp;
    @Id
    private String follows;

    public Follow(){}

    public Follow(String simp, String follows) {
        this.simp = simp;
        this.follows = follows;
    }

    public String getSimp() {
        return simp;
    }

    public void setSimp(String simp) {
        this.simp = simp;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }
}

