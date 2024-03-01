package com.sparta.my_memo.repository;

import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoRepositoryImpl implements MemoRepository {
    private static Map<Long, Memo> memoMap = new HashMap<>();

    @Override
    public List<MemoResponseDto> findAllMemo() {
        List<MemoResponseDto> memoList = memoMap.values().stream()
                .map(MemoResponseDto::new).toList();
        return memoList;
    }

    @Override
    public MemoResponseDto saveMemo(Memo memo) {
        Long maxId = memoMap.size()>0? Collections.max(memoMap.keySet())+1:1;
        memo.setId(maxId);
        memoMap.put(memo.getId(),memo);
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    @Override
    public MemoResponseDto findMemoById(Long id) {
        MemoResponseDto memoResponseDto = new MemoResponseDto(memoMap.get(id));
        return memoResponseDto;
    }

    @Override
    public Optional<MemoResponseDto> updateMemo(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoMap.get(id);
        memo.update(memoRequestDto);
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return Optional.of(memoResponseDto);
    }
}
