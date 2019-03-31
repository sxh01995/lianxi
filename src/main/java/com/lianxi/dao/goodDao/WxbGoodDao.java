package com.lianxi.dao.goodDao;

import com.lianxi.entity.good.WxbGood;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
//商品信息
@Repository
@MapperScan
public interface WxbGoodDao {
    //查询所有
    List<WxbGood> findAll();
    //根据ID查询
    WxbGood findById(String goodId);
    //添加
    void insert(WxbGood good);
    //分页查询
    List<WxbGood> paging(@Param("index") Integer index,@Param("max") Integer max);
}
