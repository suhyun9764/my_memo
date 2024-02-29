package com.sparta.my_memo.controller;

import com.sparta.my_memo.Service.MemoService;
import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import com.sparta.my_memo.dto.requestDto.RequestDto;
import com.sparta.my_memo.dto.requestDto.UserRequestDto;
import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;
import com.sparta.my_memo.entity.User;
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
    public MemoResponseDto postBoard(@RequestBody RequestDto requestDto) {

        //User 생성
        UserRequestDto userRequestDto = new UserRequestDto(requestDto);
        User user = new User(userRequestDto);
        System.out.println(user.getId());
        //Memo 생성
        MemoRequestDto memoRequestDto = new MemoRequestDto(requestDto);
        Memo memo = new Memo(memoRequestDto);
        memo.setWriterId(user.getId());
        //저장
        MemoResponseDto memoResponseDto = memoService.saveUserAndMemo(user, memo);
        return memoResponseDto;
    }
    @GetMapping("/board/{id}")
    public MemoResponseDto getSelectedMemo(@PathVariable Long id) {
        //Memo id로 조회
        MemoResponseDto memoResponseDto = memoService.findMemoById(id);
        return memoResponseDto;
    }

    public String updateMemo(String memo_id, String name, String password, String content) {
        //Memo id에 맞는 Memo 가져오기
        return null;
    }

    public String deleteMemo(String memo_id, String password) {
        return null;
    }
}
