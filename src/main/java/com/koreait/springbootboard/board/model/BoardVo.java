package com.koreait.springbootboard.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVo extends BoardEntity { // select 결과를 담는 것으로
    private String username;
}
