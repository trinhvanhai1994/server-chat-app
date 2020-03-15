package com.omi.chat.controller;

import com.omi.chat.model.entity.Member;
import com.omi.chat.service.MemberService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/members")
    public List<Member> getAll() {
        return service.findAll();
    }

    @GetMapping("/members/{id}")
    public Member getById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/members/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @PutMapping("/members/{id}")
    public void updateMember(@PathVariable long id, @RequestBody Member member) {
        service.update(id, member);
    }

    @PostMapping("/members")
    public Member createRoom(@RequestBody Member member) {
        return service.save(member);
    }
}
