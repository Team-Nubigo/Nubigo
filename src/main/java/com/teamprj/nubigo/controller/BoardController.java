package com.teamprj.nubigo.controller;

import com.teamprj.nubigo.entity.Boards;
import com.teamprj.nubigo.entity.Comments;
import com.teamprj.nubigo.model.BoardDTO;
import com.teamprj.nubigo.service.BoardService;
import com.teamprj.nubigo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final CommentService commentService;
//    @PostMapping("/test/user")
//    public Users testUsers(){
//
//        Users user = new Users(1L, "test", "1234", "test계정", "주소", "상세주소", "서울", new Date());
//
//        userJpaRepository.save(user);
//
//        Users test = userJpaRepository.findById(1L).orElse(null);
//
//        return test;
//    }


    @GetMapping("/tourlist")
    public List<Boards> AllBoards(){

        System.out.println("모든 게시글 조회!");

        return boardService.getTourlist();
    }

    @GetMapping("/tourlist/{boardNumber}")
    public List readBoards(@PathVariable Long boardNumber){

        System.out.println("게시글 조회!");

        List list = new ArrayList();

        Boards board = boardService.readTour(boardNumber);
        Comments comment = commentService.getComments(boardNumber);

        list.add(board);

        if(comment != null)
            list.add(comment);


        return list;
    }

    @PostMapping("/tourlist/{boardNumber}")
    public Boards createBoards(@PathVariable Long boardNumber, @RequestBody BoardDTO dto){

        System.out.println("게시글 생성!");

        return boardService.createTour(boardNumber, dto);
    }


    @PutMapping("/tourlist/{boardNumber}")
    public Boards modifyBoards(@RequestBody BoardDTO dto, @PathVariable Long boardNumber){

        System.out.println("게시글 수정!");

        return boardService.modifyTour(boardNumber,dto);
    }

    @DeleteMapping("/tourlist/{boardNumber}")
    public String deleteBoards(@PathVariable Long boardNumber){

        System.out.println("게시글 삭제!");

        return boardService.deleteTour(boardNumber);
    }
}
