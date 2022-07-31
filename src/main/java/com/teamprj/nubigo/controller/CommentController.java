package com.teamprj.nubigo.controller;

import com.teamprj.nubigo.entity.Comments;
import com.teamprj.nubigo.model.CommentDTO;
import com.teamprj.nubigo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 코멘트 생성
    @PostMapping("/tourlist/{boardNumber}/comment")
    public Comments createComment(@PathVariable Long boardNumber,
                                @RequestBody CommentDTO dto){

        Comments comment = commentService.createComments(boardNumber,dto);

        return comment;
    }

    // 코멘트 수정
    @PutMapping("/tourlist/{boardNumber}/{commentNumber}")
    public Comments modifyComment(@PathVariable Long boardNumber,
                                @PathVariable Long commentNumber,
                                @RequestBody CommentDTO dto){

        Comments comment = commentService.modifyComments(boardNumber, commentNumber, dto);

        return comment;
    }

    // 코멘트 삭제
    @DeleteMapping("/tourlist/{boardNumber}/{commentNumber}")
    public String deleteComment(@PathVariable Long boardNumber,
                                @PathVariable Long commentNumber){

        String result = commentService.deleteComments(commentNumber);

        return result;
    }

}
