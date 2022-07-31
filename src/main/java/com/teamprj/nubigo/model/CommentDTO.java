package com.teamprj.nubigo.model;

import com.teamprj.nubigo.entity.Comments;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long id;
    private Long commentNumber;
    private String commentWriter;
    private String commentContent;
    private Date commentAt;
    private int commentGood;
    private Long boardNumber;

    @Builder
    public Comments toEntity(){
        return Comments
                .builder()
                .id(id)
                .commentWriter(commentWriter)
                .commentContent(commentContent)
                .commentAt(commentAt)
                .commentGood(commentGood)
                .boardNumber(boardNumber)
                .build();
    }
}
