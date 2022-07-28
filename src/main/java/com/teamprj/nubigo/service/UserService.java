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

    // 회원가입
    public Users signup(UserDTO dto){

        UserDTO userDTO = new UserDTO(dto.getId(), dto.getUserId()
                                    ,dto.getUserPassword(),dto.getUserName()
                                    ,dto.getUserAddress(),dto.getUserAddressDetail()
                                    ,dto.getUserTourlist(),new Date());
        Users user = userDTO.toEntity();

        userJpaRepository.save(user);

        Users test = userJpaRepository.findById(dto.getId()).orElse(null);

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
                ,dto.getUserTourlist(),new Date());

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
