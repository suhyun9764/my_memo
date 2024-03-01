package com.sparta.my_memo.controller;

import com.sparta.my_memo.Service.MemoService;
import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import com.sparta.my_memo.dto.responseDto.ErrorResponseDto;
import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class Controller {

    private final MemoService memoService;

    @GetMapping("/board")
    public List<MemoResponseDto> getBoard() {
        List<MemoResponseDto> memos = memoService.findAllMemo();
        return memos;
    }

    @PostMapping("/board")
    public MemoResponseDto postBoard(@RequestBody MemoRequestDto memoRequestDto) {
        MemoResponseDto memoResponseDto = memoService.saveUserAndMemo(memoRequestDto);
        return memoResponseDto;
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<?> getSelectedMemo(@PathVariable Long id) {
        try {
            MemoResponseDto memoResponseDto = memoService.findMemoById(id);
            return ResponseEntity.ok(memoResponseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
        }
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<?> updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        try {
            MemoResponseDto updatedMemo = memoService.updateMemo(id, memoRequestDto);
            return ResponseEntity.ok(updatedMemo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
        }
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        try {
            String completeMessage = memoService.deleteMemo(id, memoRequestDto);
            return ResponseEntity.ok(completeMessage);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
