package com.sparta.my_memo.Service;

import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;
import com.sparta.my_memo.repository.MemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    public List<MemoResponseDto> findAllMemo() {
        List<MemoResponseDto> allMemo = memoRepository.findAllMemo();
        return allMemo;
    }

    public MemoResponseDto saveUserAndMemo(MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto);
        MemoResponseDto memoResponseDto = memoRepository.saveMemo(memo);
        return memoResponseDto;
    }

    public MemoResponseDto findMemoById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Null이 입력되었습니다");

        Optional<MemoResponseDto> memoById = memoRepository.findMemoById(id);
        if (memoById.isPresent())
            return memoById.get();

        throw new IllegalArgumentException("찾으시는 메모가 존재하지 않습니다");
    }

    public MemoResponseDto updateMemo(Long id, MemoRequestDto memoRequestDto) {
        Optional<MemoResponseDto> memoById = memoRepository.findMemoById(id);
        if (memoById.isPresent()) {
            boolean isCorrectUser = checkAvailable(id, memoRequestDto);
            if(isCorrectUser) {
                MemoResponseDto memoResponseDto = memoRepository.update(id,memoRequestDto);
                return memoResponseDto;
            }
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        throw new IllegalArgumentException("찾으시는 메모가 존재하지 않습니다");
    }

    private boolean checkAvailable(Long id, MemoRequestDto memoRequestDto) {
        boolean isAvailable = memoRepository.checkAvailable(id, memoRequestDto);
        return isAvailable;
    }


    //목록 전체 조회
    //글 저장
    //메모 아이디로 조회
    //
}
