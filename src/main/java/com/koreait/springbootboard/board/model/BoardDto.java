package com.koreait.springbootboard.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class BoardDto {  // select 할때 전달되는 값
    private int iboard;
    private int icategory;
    private int recordCount;
    private int currentPage;
    private int startIdx;
}
