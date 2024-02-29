package com.sparta.my_memo.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDto {
    private String name;
    private String password;
    private String title;
    private String content;
}
