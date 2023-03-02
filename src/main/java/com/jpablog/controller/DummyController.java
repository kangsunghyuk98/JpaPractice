package com.jpablog.controller;

import com.jpablog.model.RoleType;
import com.jpablog.model.User;
import com.jpablog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DummyController {

    private final UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user) {

        System.out.println("username : " + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료 되었습니다.";
    }

    @GetMapping("/dummy/user/{id}")
    public User selectOneUser (@PathVariable("id") int id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당유저는 없습니다."));
    }
}
