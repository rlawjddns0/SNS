package com.pastcampus.sns.model;

import com.pastcampus.sns.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String userName;
    private String password;
    private UserRole userRole;
    private Timestamp registerAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static User fromEntity(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getRegisterAt(),
                userEntity.getUpdatedAt(),
                userEntity.getDeletedAt());
    }
}
