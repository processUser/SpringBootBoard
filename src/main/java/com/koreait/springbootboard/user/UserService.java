package com.koreait.springbootboard.user;

import com.koreait.springbootboard.MyUserUtils;
import com.koreait.springbootboard.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserMapper mapper;
    @Autowired private MyUserUtils userUtils;

    public int join(UserEntity entity){
        //TODO 유효성검사

        entity.setUpw(BCrypt.hashpw(entity.getUpw(), BCrypt.gensalt()));
        try {
            return mapper.insUser(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //0: DB에러, 1: 로그인 성공, 2:아이디 없음, 3:비밀번호 틀림
    public int login(UserEntity entity){
        String pw = entity.getUpw();
        UserEntity ue = null;

        try{
            ue = mapper.selUser(entity);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        if(ue != null){ // 아이디 or 회원정보 있음
            if(BCrypt.checkpw(pw, ue.getUpw())){ // 비밀번호 일치
                ue.setUpw(null);
                userUtils.setLoginUser(ue);
                return 1;
            }else { // 비밀번호 불일치
                return 3;
            }

        } else { // 아이디 or 회원정보 없음
            return 2;
        }
    }
}
