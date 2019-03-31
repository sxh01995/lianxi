package com.lianxi.dao.goodDao;

import com.lianxi.entity.good.WxbGoodSku;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@MapperScan
public interface WxbGoodSkuDao {
    List<WxbGoodSku> findById(String id);
}
