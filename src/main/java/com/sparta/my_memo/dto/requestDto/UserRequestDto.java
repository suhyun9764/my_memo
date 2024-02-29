package com.sparta.my_memo.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    private String name;
    private String password;

    public UserRequestDto(RequestDto requestDto) {
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
    }
}
