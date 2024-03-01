package com.sparta.my_memo.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoRequestDto {
    private String title;
    private String content;
    private String writer;
    private String password;

//    public MemoRequestDto(String title, String content, String writer) {
//        this.title = title;
//        this.content = content;
//        this.writer = writer;
//    }
}
