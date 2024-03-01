package com.sparta.my_memo.entity;

import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Memo {
    private Long id;
    private String title;
    private LocalDate date;
    private String content;
    private String writer;
    private String password;

    public Memo(MemoRequestDto memoRequestDto) {
        this.title = memoRequestDto.getTitle();
        this.content = memoRequestDto.getContent();
        this.writer = memoRequestDto.getWriter();
        this.password = memoRequestDto.getPassword();
        this.date = LocalDate.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean checkPassword(MemoRequestDto memoRequestDto){
        return this.password.equals(memoRequestDto.getPassword());
    }

    public void update(MemoRequestDto memoRequestDto) {
        this.title = memoRequestDto.getTitle();
        this.content = memoRequestDto.getContent();
        this.writer = memoRequestDto.getWriter();
    }
}
