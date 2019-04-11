package com.lianxi.service.good;

import com.lianxi.entity.good.WxbGood;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WxbGoodService {
    //查询所有
    List<WxbGood> findAll();
    //添加
    String insert(WxbGood wxbGood, MultipartFile file, MultipartFile file1, MultipartFile file2);
    //根据ID查询
    WxbGood findById(String goodId);
    //商品信息全表查询分页页数
    Integer divide();
    //分页显示
    List<WxbGood> paging(Integer index);
    //分页起始条数
    Integer start(Integer index);
}
