package com.sparta.my_memo.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemoRequestDto {
    private String title;
    private String content;
    private String writer;
    private String password;

}
