package com.pastcampus.sns.controller;

import com.pastcampus.sns.controller.request.UserJoinRequest;
import com.pastcampus.sns.controller.request.UserLoginRequest;
import com.pastcampus.sns.controller.response.Response;
import com.pastcampus.sns.controller.response.UserJoinResponse;
import com.pastcampus.sns.controller.response.UserLoginResponse;
import com.pastcampus.sns.model.User;
import com.pastcampus.sns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {

        User user = userService.join(request.getUserName(), request.getPassword());
        System.out.println(user.toString());
        return Response.success(UserJoinResponse.fromUser(user));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login (@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getUserName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }
}
