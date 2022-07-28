package com.teamprj.nubigo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Column(name = "user_password", nullable = false, length = 50)
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

    public Users(String userId, String userPassword){
        this.userId = userId;
        this.userPassword = userPassword;
    }

    @Builder
    public Users(Long id, String userId, String userPassword, String userName, String userAddress, String userAddressDetail, String userTourlist, Date userAt) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userAddressDetail = userAddressDetail;
        this.userTourlist = userTourlist;
        this.userAt = userAt;
    }
}
