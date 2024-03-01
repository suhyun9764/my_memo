package com.sparta.my_memo.dto.responseDto;

import com.sparta.my_memo.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class MemoResponseDto {
    private Long id;
    private String title;
    private LocalDate date;
    private String content;
    private String writer;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.date = memo.getDate();
        this.content = memo.getContent();
        this.writer = memo.getWriter();
    }
}
