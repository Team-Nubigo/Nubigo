package com.teamprj.nubigo.model;

import com.teamprj.nubigo.entity.Boards;
import com.teamprj.nubigo.entity.Comments;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long id;
    private Long boardNumber;
    private String boardWriter;
    private String boardTitle;
    private String boardContent;
    private Date boardAt;
    private int boardCount;
    private String boardPhoto;
    private int boardGood;
    private String boardTourlist;



    @Builder
    public Boards toEntity(){

        return Boards.builder()
                .id(id)
                .boardNumber(boardNumber)
                .boardWriter(boardWriter)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardAt(boardAt)
                .boardCount(boardCount)
                .boardPhoto(boardPhoto)
                .boardGood(boardGood)
                .boardTourlist(boardTourlist)
                .build();
    }

}
