package com.pastcampus.sns.controller.response;

import com.pastcampus.sns.model.User;
import com.pastcampus.sns.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinResponse {
    private Long id;
    private String userName;
    private UserRole role;


    public static UserJoinResponse fromUser(User user) {
        return new UserJoinResponse(user.getId(),
                user.getUserName(),
                user.getUserRole());
    }

}
