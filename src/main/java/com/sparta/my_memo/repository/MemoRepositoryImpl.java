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
                .map(MemoResponseDto::new).sorted(Comparator.comparing(MemoResponseDto::getId).reversed())
                .toList();
        return memoList;
    }

    @Override
    public MemoResponseDto saveMemo(Memo memo) {
        Long maxId = memoMap.size() > 0 ? Collections.max(memoMap.keySet()) + 1 : 1;
        memo.setId(maxId);
        memoMap.put(memo.getId(), memo);
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    @Override
    public Optional<MemoResponseDto> findMemoById(Long id) {
        if (memoMap.containsKey(id)) {
            Memo memo = memoMap.get(id);
            MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
            return Optional.of(memoResponseDto);
        }

        return Optional.empty();
    }

    @Override
    public boolean checkAvailable(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoMap.get(id);
        return memo.checkPassword(memoRequestDto);
    }

    @Override
    public MemoResponseDto update(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoMap.get(id);
        memo.update(memoRequestDto);
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    @Override
    public void delete(Long id) {
        memoMap.remove(id);
    }

}
