package com.sparta.my_memo.controller;

import com.sparta.my_memo.Service.MemoService;
import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
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
        //전체 목록 가져오기
        List<MemoResponseDto> memos = memoService.findAllMemo();
        return memos;
    }

    @PostMapping("/board")
    public MemoResponseDto postBoard(@RequestBody MemoRequestDto memoRequestDto) {
        //저장
        MemoResponseDto memoResponseDto = memoService.saveUserAndMemo(memoRequestDto);
        return memoResponseDto;
    }

    @GetMapping("/board/{id}")
    public MemoResponseDto getSelectedMemo(@PathVariable Long id) {
        //Memo id로 조회
        try {
            MemoResponseDto memoResponseDto = memoService.findMemoById(id);
            return memoResponseDto;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    @PutMapping("/board/{id}")
    public MemoResponseDto updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto ) {
        try{
            MemoResponseDto updatedMemo = memoService.updateMemo(id,memoRequestDto);
            return updatedMemo;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    @DeleteMapping("/board/{id}")
    public ResponseEntity deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        try {
            memoService.deleteMemo(id,memoRequestDto);
            return ResponseEntity.ok("정상적으로 삭제되었습니다");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
