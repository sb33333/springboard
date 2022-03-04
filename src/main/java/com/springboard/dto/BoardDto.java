package com.springboard.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class BoardDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardIdx;
    private String title;
    private String content;
    private int hitCnt;
    private String creatorId;
    private LocalDateTime createdDateTime;
    private String updatorId;
    private LocalDateTime updatedDateTime;

}
