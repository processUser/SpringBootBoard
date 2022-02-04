package com.koreait.springbootboard.board.comment;

import com.koreait.springbootboard.MyUserUtils;
import com.koreait.springbootboard.ResultVo;
import com.koreait.springbootboard.board.comment.model.BoardCommentEntity;
import com.koreait.springbootboard.board.comment.model.BoardCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired private MyUserUtils myUserUtils;
    @Autowired private CommentMapper mapper;

    public ResultVo insCmt(BoardCommentEntity entity) {
        entity.setIuser(myUserUtils.getLoginUserPk());
        int result = mapper.insCmt(entity);
        return new ResultVo(result);
    }

    public List<BoardCommentVo> selCommentList(BoardCommentEntity entity) {
        return mapper.selCommentList(entity);
    }
}
