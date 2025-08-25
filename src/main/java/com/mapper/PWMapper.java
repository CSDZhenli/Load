package com.mapper;

import com.pojo.PW;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//PWMapper代理
public interface PWMapper {
    List<PW> selectAll();
    PW selectIdByPassword(String passwords);
    PW selectUrlById(@Param("id") int id);
}
