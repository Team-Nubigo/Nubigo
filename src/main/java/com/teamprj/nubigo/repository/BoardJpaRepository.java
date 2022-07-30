package com.teamprj.nubigo.repository;

import com.teamprj.nubigo.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardJpaRepository extends JpaRepository<Boards, Long> {

}
