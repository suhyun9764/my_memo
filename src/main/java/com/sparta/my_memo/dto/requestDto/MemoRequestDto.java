package com.sparta.my_memo.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemoRequestDto {
    private String title;
    private String content;
    private String writer;
    private String password;

}
