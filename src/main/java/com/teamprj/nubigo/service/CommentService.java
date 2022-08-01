package com.teamprj.nubigo.service;

import com.teamprj.nubigo.entity.Comments;
import com.teamprj.nubigo.model.CommentDTO;
import com.teamprj.nubigo.repository.CommentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentJpaRepository commentJpaRepository;


    // 해당 게시글 댓글 모든 댓글
    public List<Comments> getComments(Long boardNumber){

        List<Comments> test = commentJpaRepository.findByboardNumber(boardNumber);

        return test;
    }

    // 댓글 추가
    public Comments createComments(Long boardNumber, CommentDTO dto){

        CommentDTO commentDTO = new CommentDTO(dto.getId(),dto.getCommentNumber(),
                dto.getCommentWriter(), dto.getCommentContent(),new Date(),
                dto.getCommentGood(), boardNumber);

        Comments comment = commentDTO.toEntity();

        System.out.println(comment.toString());

        commentJpaRepository.save(comment);


        Comments test = commentJpaRepository.findById(
                commentJpaRepository.findmaxCommentnumber(boardNumber)
        ).orElse(null);

        return test;
    }

    // 댓글 수정
    public Comments modifyComments(Long boardNumber, Long commentNumber, CommentDTO dto) {

        CommentDTO save =  new CommentDTO(dto.getId(),commentNumber,
                dto.getCommentWriter(), dto.getCommentContent(),new Date(),
                dto.getCommentGood(), boardNumber);

        Comments comment = save.toEntity();

        commentJpaRepository.save(comment);

        Comments test = commentJpaRepository.findById(dto.getCommentNumber()).orElse(null);

        return test;
    }

    // 댓글 삭제
    public String deleteComments(Long commentNumber){

        commentJpaRepository.deleteById(commentNumber);


        if(commentJpaRepository.findById(commentNumber).orElse(null) == null){
            return commentNumber + "번 댓글 삭제 완료";
        }

        return "삭제 실패";
    }
}
