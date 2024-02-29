package com.sparta.my_memo.Service;

import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;
import com.sparta.my_memo.entity.User;
import com.sparta.my_memo.repository.MemoRepository;
import com.sparta.my_memo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final UserRepository userRepository;
    public List<MemoResponseDto> findAllMemo() {
        List<MemoResponseDto> allMemo = memoRepository.findAllMemo();
        return allMemo;
    }

    public MemoResponseDto saveUserAndMemo(User user, Memo memo) {
        userRepository.save(user);
        MemoResponseDto memoResponseDto = memoRepository.saveMemo(memo);
        return memoResponseDto;
    }
    //목록 전체 조회
    //글 저장
    //메모 아이디로 조회
    //
}
