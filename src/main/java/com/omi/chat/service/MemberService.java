package com.omi.chat.service;

import com.omi.chat.model.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();
    Member save(Member room);
    Member findById(long id);
    void update(Long id, Member room);
    void deleteById(long id);
}
