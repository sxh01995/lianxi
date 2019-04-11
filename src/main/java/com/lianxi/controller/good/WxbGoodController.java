package com.lianxi.controller.good;

import com.lianxi.entity.good.WxbGood;
import com.lianxi.service.good.WxbGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/good")
public class WxbGoodController {
    @Autowired
    private WxbGoodService goodService;
    //查询数据有多少条
    @RequestMapping("/findAll")
    public Integer findAll(){

        List<WxbGood> all = goodService.findAll();
        return all.size();
    }
    //分页查询
    @RequestMapping("/paging")
    public List<WxbGood> paging(Integer index){
        return goodService.paging(index);
    }
    //全表查询分页总页数
    @RequestMapping("/pagination")
    public Integer pagination(){
        return goodService.divide();
    }
    @RequestMapping("/add")
    public String add(WxbGood wxbGood,MultipartFile file, MultipartFile file1, MultipartFile file2){
        return goodService.insert(wxbGood,file,file1,file2);
    }
    //查询单个商品信息
    @RequestMapping("/findById")
    public WxbGood findById(String id){
        return goodService.findById(id);
    }
}
