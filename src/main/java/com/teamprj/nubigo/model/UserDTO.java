package com.teamprj.nubigo.model;


import com.teamprj.nubigo.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String userId;
    private String userPassword;
    private String userName;
    private String userAddress;
    private String userAddressDetail;
    private String userTourlist;
    private Date userAt;


    @Builder
    public Users toEntity(){
        return Users
                .builder()
                .id(id)
                .userId(userId)
                .userPassword(userPassword)
                .userName(userName)
                .userAddress(userAddress)
                .userAddressDetail(userAddressDetail)
                .userTourlist(userTourlist)
                .userAt(userAt)
                .build();
    }
}
