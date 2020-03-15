package com.omi.chat.model.response;

import lombok.Data;

import java.time.Instant;

@Data
public class UserProfile {
    private Long id;
    private String username;
    private String name;
    private Instant joinedAt;
    private Long pollCount;
    private Long voteCount;

    public UserProfile() {
    }

    public UserProfile(Long id, String username, String name, Instant joinedAt, Long pollCount, Long voteCount) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.pollCount = pollCount;
        this.voteCount = voteCount;
    }
}