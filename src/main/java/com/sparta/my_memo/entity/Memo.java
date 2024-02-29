package com.sparta.my_memo.entity;

import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Memo {
    private Long id;
    private String title;
    private LocalDate date;
    private String content;
    private UUID writerId;

    public Memo(MemoRequestDto memoRequestDto) {
        this.title = memoRequestDto.getTitle();
        this.content = memoRequestDto.getContent();
        this.date = LocalDate.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWriterId(UUID writerId) {
        this.writerId = writerId;
    }
}
