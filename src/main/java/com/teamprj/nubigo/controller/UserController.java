package com.teamprj.nubigo.controller;

import com.teamprj.nubigo.entity.Users;
import com.teamprj.nubigo.model.UserDTO;
import com.teamprj.nubigo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public Users signup(@RequestBody UserDTO dto){

        System.out.println("회원가입 시작!");

        dto.setUserPassword(bCryptPasswordEncoder.encode(dto.getUserPassword()));

        Users user = userService.signup(dto);

        return user;
    }

    // 회원 정보 확인  일단 id를 테스트 단계에서는 받아오고
    // 나중에 jwt 토큰에서 가져올 수 있게 설정
    @GetMapping("/profile/{id}")
    public Users readProfile(@PathVariable Long id){

        System.out.println("회원 조회 시작!");

        Users user = userService.readUsers(id);

        return user;
    }

    // 회원 정보 수정
    @PutMapping("/profile/{id}")
    public Users modifyProfile(@RequestBody UserDTO dto, @PathVariable Long id){

        System.out.println("회원 정보 수정 시작!");

        Users user = userService.modifyUsers(dto, id);

        return user;
    }

    // 회원 탈퇴
    @DeleteMapping("/profile/{id}")
    public String deleteProfile(@PathVariable Long id){

        System.out.println("회원 탈퇴 시작!");

        String result = userService.deleteUsers(id);

        return result;
    }
/*
    // 로그인
    @GetMapping("/login")
    public Users login(@RequestBody UserDTO dto){

        System.out.println("로그인 시작");

        Users user = userService.login(dto);

        return user;
    }*/

    // 로그아웃
    @GetMapping("/logout")
    public void logout(){

    }

}
