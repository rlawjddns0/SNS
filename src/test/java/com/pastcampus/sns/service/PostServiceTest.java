package com.pastcampus.sns.service;

import com.pastcampus.sns.exception.ErrorCode;
import com.pastcampus.sns.exception.SnsApplicationException;
import com.pastcampus.sns.model.entity.PostEntity;
import com.pastcampus.sns.model.entity.UserEntity;
import com.pastcampus.sns.repository.PostEntityRepository;
import com.pastcampus.sns.repository.UserEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest
public class PostServiceTest {


    @Autowired
    private PostService postService;

    @MockitoBean
    private PostEntityRepository postEntityRepository;
    @MockitoBean
    private UserEntityRepository userEntityRepository;

    @Test
    void 포스트작성이_성공(){
        String title = "title";
        String body = "body";
        String userName = "userName";

        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(mock(UserEntity.class)));
        when(postEntityRepository.save(any())).thenReturn(mock(PostEntity.class));

        Assertions.assertDoesNotThrow(() -> postService.create(title, body, userName));

    }

    @Test
    void 포스트작성시_요청한User가_존재하지않는경우(){
        String title = "title";
        String body = "body";
        String userName = "userName";

        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());

        SnsApplicationException snsApplicationException = Assertions.assertThrows(SnsApplicationException.class, () -> postService.create(title, body, userName));
        Assertions.assertEquals(ErrorCode.USER_NOT_FOUND, snsApplicationException.getErrorCode());


    }
}
