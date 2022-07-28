package com.teamprj.nubigo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@ToString
@Entity(name="comment")
public class Comments {

    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNumber;

    @Column(name = "comment_writer", nullable = false, length = 30)
    private String commentWriter;

    @Column(name = "comment_content", nullable = false, length = 200)
    private String commentContent;

    @Column(name = "comment_at", nullable = false)
    private Date commentAt;

    @Column(name = "comment_good", nullable = false)
    private int commentGood;

    @Column(name = "board_number", nullable = false)
    private Long boardNumber;

    @Builder
    public Comments(Long id, Long boardNumber, Long commentNumber, String commentWriter, String commentContent, Date commentAt, int commentGood) {
        this.id = id;
        this.commentNumber = commentNumber;
        this.commentWriter = commentWriter;
        this.commentContent = commentContent;
        this.commentAt = commentAt;
        this.commentGood = commentGood;
        this.boardNumber = boardNumber;
    }
}
