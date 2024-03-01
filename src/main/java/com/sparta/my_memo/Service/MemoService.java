package com.sparta.my_memo.Service;

import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;
import com.sparta.my_memo.repository.MemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sparta.my_memo.constant.Message.*;

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
            throw new IllegalArgumentException(NULL_INPUT_VALUE);

        Optional<MemoResponseDto> memoById = memoRepository.findMemoById(id);
        if (memoById.isPresent())
            return memoById.get();

        throw new IllegalArgumentException(WRONG_MEMO_NUMBER);
    }

    public MemoResponseDto updateMemo(Long id, MemoRequestDto memoRequestDto) {
        Optional<MemoResponseDto> memoById = memoRepository.findMemoById(id);
        if (memoById.isPresent()) {
            boolean isCorrectUser = checkAvailable(id, memoRequestDto);
            if (isCorrectUser) {
                MemoResponseDto memoResponseDto = memoRepository.update(id, memoRequestDto);
                return memoResponseDto;
            }
            throw new IllegalArgumentException(WRONG_PASSWORD);
        }

        throw new IllegalArgumentException(WRONG_MEMO_NUMBER);
    }

    public String deleteMemo(Long id, MemoRequestDto memoRequestDto) {
        Optional<MemoResponseDto> memoById = memoRepository.findMemoById(id);
        if (memoById.isPresent()) {
            boolean isCorrectUser = checkAvailable(id, memoRequestDto);
            if (isCorrectUser) {
                memoRepository.delete(id);
                return DELETE_COMPLETE;
            }
            throw new IllegalArgumentException(WRONG_PASSWORD);
        }
        throw new IllegalArgumentException(WRONG_MEMO_NUMBER);

    }


    private boolean checkAvailable(Long id, MemoRequestDto memoRequestDto) {
        boolean isAvailable = memoRepository.checkAvailable(id, memoRequestDto);
        return isAvailable;
    }


}
