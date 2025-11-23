package com.pastcampus.sns.fixture;

import com.pastcampus.sns.model.entity.UserEntity;

public class UserEntityFixture {
    public static UserEntity get(String userName, String password) {
        UserEntity result = new UserEntity();
        result.setId(1L);
        result.setUserName(userName);
        result.setPassword(password);

        return result;

    }
}
