package com.koreait.springbootboard;

import com.koreait.springbootboard.user.UserMapper;
import com.koreait.springbootboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    @Autowired private UserMapper mapper;

    public UserEntity getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uid = auth.getName();
        UserEntity entity = new UserEntity();
        entity.setUid(uid);
        return mapper.selUser(entity);
    }

    public int getLoginUserPk() {
        return getLoginUser().getIuser();
    }
}
