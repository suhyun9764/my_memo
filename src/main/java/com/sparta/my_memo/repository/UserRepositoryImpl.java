package com.sparta.my_memo.repository;

import com.sparta.my_memo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository{
    Map<UUID,User> userMap = new HashMap<>();
    @Override
    public void save(User user) {
        userMap.put(user.getId(),user);
    }
}
