package com.teamprj.nubigo.controller;

import com.teamprj.nubigo.entity.Boards;
import com.teamprj.nubigo.entity.Comments;
import com.teamprj.nubigo.model.BoardDTO;
import com.teamprj.nubigo.service.BoardService;
import com.teamprj.nubigo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final CommentService commentService;

    // 페이징 처리를 해야된다
    // 10개씩 페이징 처리 필요
    @GetMapping("/tourlists")
    public List<Boards> AllBoards(){

        System.out.println("모든 게시글 조회!");

        return boardService.getTourlist();
    }
    @GetMapping("/tourlist")
    public List<Boards> AllBoards(@RequestParam (defaultValue="1") int page){

        System.out.println("페이지 게시글 조회");

        return boardService.getPageTourlist(page);
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

    @PostMapping("/tourlist")
    public Boards createBoards(@RequestBody BoardDTO dto){

        System.out.println("게시글 생성!");

        return boardService.createTour(dto);
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
