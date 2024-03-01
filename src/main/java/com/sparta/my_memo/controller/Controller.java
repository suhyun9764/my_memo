package com.sparta.my_memo.controller;

import com.sparta.my_memo.Service.MemoService;
import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;
import lombok.AllArgsConstructor;
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
        MemoResponseDto memoResponseDto = memoService.findMemoById(id);
        return memoResponseDto;
    }
//    @PutMapping("/board/{id}")
//    public MemoResponseDto updateMemo(@PathVariable Long id, @RequestBody RequestDto requestDto ) {
//        //Memo id에 해당하는 사용자의 비밀번호가 같은지 확인
//        Optional<MemoResponseDto> updatedMemo = memoService.updateMemo(id,requestDto);
//        return updatedMemo.get();
//    }

    public String deleteMemo(String memo_id, String password) {
        return null;
    }
}
