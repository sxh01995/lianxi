package com.lianxi.dao.goodDao;

import com.lianxi.entity.good.WxbGoodType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@MapperScan
public interface WxbGoodTypeDao {
    List<WxbGoodType> findAll();
}
