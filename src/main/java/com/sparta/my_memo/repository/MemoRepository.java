package com.sparta.my_memo.repository;

import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;

import java.util.List;

public interface MemoRepository {

    // 게시글 전체 조회
    List<MemoResponseDto> findAllMemo();
    // 게시글 등록
    MemoResponseDto saveMemo(Memo memo);
    // 게시글 아이디로 조회
    MemoResponseDto findMemoById();
    //

}
