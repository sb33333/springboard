package com.springboard.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(schema = "springboot", name = "t_board")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "board_idx")
    private int boardIdx;
    private String title;
    private String contents;
    @Column(name = "hit_cnt")
    private int hitCnt;
    @Column(name = "creator_id")
    private String creatorId;
    @Column(name = "created_datetime")
    private LocalDateTime createdDateTime;
    @Column(name = "updator_id")
    private String updatorId;
    @Column(name = "updated_datetime")
    private LocalDateTime updatedDateTime;
    @Column(name = "deleted_yn")
    private boolean deletedYn;

}
