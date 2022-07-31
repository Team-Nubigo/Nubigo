package com.teamprj.nubigo.repository;

import com.teamprj.nubigo.entity.Boards;
import com.teamprj.nubigo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardJpaRepository extends JpaRepository<Boards, Long> {
    @Query(value = "select max(board_number) from board where id = :id", nativeQuery = true )
    Long findmaxBoardnumber(@Param("id")Long id);

    @Query(value = "select * from board order by board_number desc limit :page, 10;", nativeQuery = true )
    List<Boards> findpageBoard(@Param("page") int page);
}
