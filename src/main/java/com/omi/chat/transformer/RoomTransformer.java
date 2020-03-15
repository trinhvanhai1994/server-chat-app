package com.omi.chat.transformer;

import com.omi.chat.model.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomTransformer {
    public void updateEntity(Room roomLocal, Room room) {
        if (room.getName() != null) {
            roomLocal.setName(room.getName());
        }
        if (room.getAuthor() != null) {
            roomLocal.setAuthor(room.getAuthor());
        }
    }
}
