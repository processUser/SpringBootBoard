package com.koreait.springbootboard.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardEntity { // Db 와 1:1 매핑
    private int iboard;
    private int icategory;
    private String title;
    private String ctnt;
    private int iuser;
    private int hits;
    private int isdel;
    private String rdt;
    private String mdt;
    private String lastip;
}
