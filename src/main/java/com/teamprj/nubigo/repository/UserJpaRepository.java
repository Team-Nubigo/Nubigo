package com.teamprj.nubigo.repository;

import com.teamprj.nubigo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long> {
}
