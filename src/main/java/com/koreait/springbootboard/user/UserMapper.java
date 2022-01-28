package com.koreait.springbootboard.user;

import com.koreait.springbootboard.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserEntity selUser(UserEntity entity);
    int insUser(UserEntity entity);
}
