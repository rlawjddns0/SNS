package com.pastcampus.sns.service;

import com.pastcampus.sns.exception.ErrorCode;
import com.pastcampus.sns.exception.SnsApplicationException;
import com.pastcampus.sns.model.entity.PostEntity;
import com.pastcampus.sns.model.entity.UserEntity;
import com.pastcampus.sns.repository.PostEntityRepository;
import com.pastcampus.sns.repository.UserEntityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {


    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;


    @Transactional
    public void create(String title, String body, String userName) {
        //user find
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s is not found", userName)));


        //post save
        postEntityRepository.save(new PostEntity());

        //return

    }
}
