package com.sparta.my_memo.Service;

import com.sparta.my_memo.dto.requestDto.MemoRequestDto;
import com.sparta.my_memo.dto.responseDto.MemoResponseDto;
import com.sparta.my_memo.entity.Memo;
import com.sparta.my_memo.repository.MemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        MemoResponseDto memoById = memoRepository.findMemoById(id);
        return memoById;
    }

//    public Optional<MemoResponseDto> updateMemo(Long id, RequestDto requestDto) {
//        UUID writerId = findWriterId(id);
//        boolean isAvailable = checkAvailable(requestDto, writerId);
//        if(isAvailable){
//            userRepository.updateUser(writerId,requestDto);
//            Optional<MemoResponseDto> memoResponseDto = memoRepository.updateMemo(id, requestDto);
//            return memoResponseDto;
//        }else{
//            throw new IllegalArgumentException("비밀번호가 틀렸습니다");
//        }
//    }
//
//    private boolean checkAvailable(RequestDto requestDto, UUID writerId) {
//        String password = requestDto.getPassword();
//        boolean isAvailable = userRepository.checkAvailable(writerId, password);
//        return isAvailable;
//    }



    //목록 전체 조회
    //글 저장
    //메모 아이디로 조회
    //
}
