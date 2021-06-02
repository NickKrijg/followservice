package com.kwetter.followservice.entity;

import java.io.Serializable;
import java.util.Objects;

public class FollowId implements Serializable {

    private String simp;
    private String follows;

    public FollowId() {
    }

    public FollowId(String simp, String follows) {
        this.simp = simp;
        this.follows = follows;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowId followId = (FollowId) o;
        return simp.equals(followId.simp) &&
                follows.equals(followId.follows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simp, follows);
    }
}

