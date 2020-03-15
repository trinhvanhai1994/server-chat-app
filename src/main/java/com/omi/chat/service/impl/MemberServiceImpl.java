package com.omi.chat.service.impl;

import com.omi.chat.model.entity.Member;
import com.omi.chat.repository.MemberRepository;
import com.omi.chat.service.MemberService;
import com.omi.chat.transformer.MemberTransformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;
    private final MemberTransformer transformer;

    public MemberServiceImpl(MemberRepository repository, MemberTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    @Override
    public List<Member> findAll() {
        return repository.findAll();
    }

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public Member findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Member member) {
        Member entity = findById(id);
        if (entity != null) {
            transformer.updateMember(entity, member);
            save(entity);
        }
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
