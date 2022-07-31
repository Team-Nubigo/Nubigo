package com.teamprj.nubigo.service;

import com.teamprj.nubigo.entity.Boards;
import com.teamprj.nubigo.model.BoardDTO;
import com.teamprj.nubigo.repository.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJpaRepository boardJpaRepository;

    // /tourlist - 전체 게시글 보기 메인페이지
    public List<Boards> getTourlist(){

        List<Boards> boards = boardJpaRepository.findAll();

        return boards;
    }

    // tourlist - 페이지 10개 게시글 보기
    public List<Boards> getPageTourlist(int page){

        int pageNum = (page - 1) * 10;

        List<Boards> boards = boardJpaRepository.findpageBoard(pageNum);

        return boards;
    }


    //  /tourlist/:board_number - 게시판 상세 조회   /GET
    public Boards readTour(Long boardNumber){

        Boards board = boardJpaRepository.findById(boardNumber).orElse(null);
        return board;
    }

    //  /tourlist/:board_number - 게시판 수정   /PUT
    public Boards modifyTour(Long boardNumber, BoardDTO dto){

        Long id = boardJpaRepository.findById(boardNumber).get().getId();

        BoardDTO boardDTO = new BoardDTO(id, boardNumber, dto.getBoardWriter()
                , dto.getBoardTitle(), dto.getBoardContent(), new Date()
                , dto.getBoardCount(), dto.getBoardPhoto(),dto.getBoardGood(),dto.getBoardTourlist());

        Boards board = boardDTO.toEntity();

        boardJpaRepository.save(board);

        Boards test = boardJpaRepository.findById(boardNumber).orElse(null);

        return test;
    }


    //  /tourlist/:board_number - 게시판 삭제  /DELETE
    public String deleteTour(Long boardNumber){

        boardJpaRepository.deleteById(boardNumber);

        String result;

        if(boardJpaRepository.findById(boardNumber).orElse(null) == null){

            result = boardNumber+"번 게시글 삭제 완료";
        }else{
            result = boardNumber+"번 게시글 삭제 실패";
        }

        return result;
    }


    //  /tourlist - 게시판 생성 /POST
    public Boards createTour(BoardDTO dto){

        BoardDTO boardDTO = new BoardDTO(dto.getId(), dto.getBoardNumber(), dto.getBoardWriter()
                , dto.getBoardTitle(), dto.getBoardContent(), new Date()
                , dto.getBoardCount(), dto.getBoardPhoto(),dto.getBoardGood(),dto.getBoardTourlist());

        Boards board = boardDTO.toEntity();

        boardJpaRepository.save(board);

        Boards test = boardJpaRepository.findById(boardJpaRepository.findmaxBoardnumber(dto.getId())).orElse(null);

        return test;
    }
}
