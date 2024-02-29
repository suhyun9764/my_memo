package com.sparta.my_memo.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemoRequestDto {
    private String title;
    private String content;

    public MemoRequestDto(RequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
