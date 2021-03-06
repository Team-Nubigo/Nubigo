package com.teamprj.nubigo.service;

import com.teamprj.nubigo.entity.Users;
import com.teamprj.nubigo.model.UserDTO;
import com.teamprj.nubigo.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;

    // 로그인 - JWT랑 SpringSecurity 설정이 필요하지만 일단 틀만 잡아두자
    public Users login(UserDTO dto){

        Users user = new Users(dto.getUserId(), dto.getUserPassword());

        Users check = userJpaRepository.findByuserId(dto.getUserId());

        System.out.println("user pw : " + user.getUserPassword());
        System.out.println("check pw : " + check.getUserPassword());
        System.out.println(check.getUserPassword() == user.getUserPassword());

        if(check.getUserPassword().equals(user.getUserPassword())){
            return check;
        }
        return null;
    }

    // 로그아웃 - JWT로 설정되어있는 Session? Token을 삭제해줘야한다
    public void logout(){

    }

    // 회원가입
    public Users signup(UserDTO dto){

        UserDTO userDTO = new UserDTO(dto.getId(), dto.getUserId()
                                    ,dto.getUserPassword(),dto.getUserName()
                                    ,dto.getUserAddress(),dto.getUserAddressDetail()
                                    ,dto.getUserTourlist(),new Date(), dto.getRoles());
        Users user = userDTO.toEntity();

        userJpaRepository.save(user);

        Users test = userJpaRepository.findByuserId(dto.getUserId());

        return test;
    }


    // 회원 정보 확인
    public Users readUsers(Long id){

        Users user = userJpaRepository.findById(id).orElse(null);

        return user;
    }

    // 회원 정보 수정
    public Users modifyUsers(UserDTO dto, Long id){

        UserDTO userDTO = new UserDTO(id, dto.getUserId()
                ,dto.getUserPassword(),dto.getUserName()
                ,dto.getUserAddress(),dto.getUserAddressDetail()
                ,dto.getUserTourlist(),new Date(), dto.getRoles());

        Users user = userDTO.toEntity();

        userJpaRepository.save(user);

        Users test = userJpaRepository.findById(id).orElse(null);

        return test;
    }

    // 회원 탈퇴
    public String deleteUsers(Long id){

        userJpaRepository.deleteById(id);

        if(userJpaRepository.findById(id).orElse(null) == null){
            return id + "번 회원님이 회원탈퇴 하셨습니다";
        }

        return "회원 탈퇴 실패";

    }
}
