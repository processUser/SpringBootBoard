package com.koreait.springbootboard.board.comment;

import com.koreait.springbootboard.board.comment.model.BoardCommentEntity;
import com.koreait.springbootboard.board.comment.model.BoardCommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int insCmt(BoardCommentEntity entity);
    List<BoardCommentVo> selCommentList(BoardCommentEntity entity);
}
