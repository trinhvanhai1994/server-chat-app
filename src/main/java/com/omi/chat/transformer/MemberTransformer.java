package com.omi.chat.transformer;

import com.omi.chat.model.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberTransformer {
    public void updateMember(Member entity, Member request) {
        if (request.getNickName() != null) {
            entity.setNickName(request.getNickName());
        }
        if (request.getRole() != null) {
            entity.setRole(request.getRole());
        }
        if (request.getRoomId() != null) {
            entity.setRoomId(request.getRoomId());
        }
        if (request.getDob() != null) {
            entity.setDob(request.getDob());
        }
    }
}
