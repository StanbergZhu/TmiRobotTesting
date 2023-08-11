package com.zjq.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjq.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM `user_data`")
    List<User> findAll();

    @Select("SELECT * FROM `user_data` WHERE user_name=#{userName} AND password=#{password}")
    User login(String userName, String password);
}
