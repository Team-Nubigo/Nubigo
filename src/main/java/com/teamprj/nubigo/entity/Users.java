package com.teamprj.nubigo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String userId;

    @Column(name = "password", nullable = false, length = 50)
    private String userPassword;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "user_address", nullable = false, length = 100)
    private String userAddress;

    @Column(name = "user_address_detail", nullable = false, length = 100)
    private String userAddressDetail;

    @Column(name = "user_tourlist", nullable = false, length = 100)
    private String userTourlist;

    @Column(name = "user_at", nullable = false)
    private Date userAt;

    @Column(name = "roles", nullable = false)
    private String roles;


    public Users(String userId, String userPassword){
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }

        return new ArrayList<>();
    }

    @Builder
    public Users(Long id, String userId, String userPassword,
                 String userName, String userAddress, String userAddressDetail,
                 String userTourlist, Date userAt,String roles) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userAddressDetail = userAddressDetail;
        this.userTourlist = userTourlist;
        this.userAt = userAt;
        this.roles = roles;
    }
}
