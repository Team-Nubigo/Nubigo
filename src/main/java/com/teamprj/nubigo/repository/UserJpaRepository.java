package com.teamprj.nubigo.repository;

import com.teamprj.nubigo.entity.Comments;
import com.teamprj.nubigo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long> {

    @Query(value = "select * from user where user_id = :userId", nativeQuery = true )
    Users findByuserId(@Param("userId")String userId);
}
