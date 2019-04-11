package com.lianxi.dao.user;

import com.lianxi.entity.user.WxbMemeber;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
@MapperScan
public interface WxbMemeberDao {
    WxbMemeber findDengLu(String account);
}
