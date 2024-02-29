package com.sparta.my_memo.entity;

import com.sparta.my_memo.dto.requestDto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
public class User {
    private UUID id;
    private String name;
    private final String password;

    public User(UserRequestDto userRequestDto) {
        this.id = UUID.randomUUID();
        this.name = userRequestDto.getName();
        this.password = userRequestDto.getPassword();
    }

    public UUID getId() {
        return id;
    }
}
