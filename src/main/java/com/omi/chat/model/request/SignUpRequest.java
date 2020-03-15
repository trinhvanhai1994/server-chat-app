package com.omi.chat.model.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String username;
    private String email;
    private String password;
}