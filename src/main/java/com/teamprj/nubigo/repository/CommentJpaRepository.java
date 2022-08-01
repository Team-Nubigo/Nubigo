package com.teamprj.nubigo.repository;

import com.teamprj.nubigo.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comments, Long> {

    @Query(value = "select * from comment where board_number = :boardNumber", nativeQuery = true )
    List<Comments> findByboardNumber(@Param("boardNumber")Long boardNumber);

    @Query(value = "select max(comment_number) from comment where board_number = :boardNumber", nativeQuery = true )
    Long findmaxCommentnumber(@Param("boardNumber")Long boardNumber);
}
