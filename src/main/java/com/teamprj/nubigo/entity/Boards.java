package com.teamprj.nubigo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "board")
public class Boards {

    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNumber;

    @Column(name = "board_writer", length = 30, nullable = false)
    private String boardWriter;

    @Column(name = "board_title", length = 100, nullable = false)
    private String boardTitle;

    @Column(name = "board_content", length = 5000, nullable = false)
    private String boardContent;

    @Column(name = "board_at", nullable = false)
    private Date boardAt;

    @Column(name = "board_count", length = 100, nullable = false)
    private int boardCount;

    @Column(name = "board_photo", length = 100, nullable = false)
    private String boardPhoto;

    @Column(name = "board_good", length = 100, nullable = false)
    private int boardGood;

    @Column(name = "board_tourlist", length = 100, nullable = false)
    private String boardTourlist;

    @Transient
    private List<Comments> comments;

    @Builder
    public Boards(Long id, String boardWriter,
                  String boardTitle, String boardContent,
                  Date boardAt, int boardCount, String boardPhoto,
                  int boardGood, String boardTourlist) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardAt = boardAt;
        this.boardCount = boardCount;
        this.boardPhoto = boardPhoto;
        this.boardGood = boardGood;
        this.boardTourlist = boardTourlist;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
