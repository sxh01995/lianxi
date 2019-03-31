package com.lianxi.controller.good;

import com.lianxi.entity.good.WxbGood;
import com.lianxi.service.good.WxbGoodServiceImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/good")
public class WxbGoodController {
    @Resource
    private WxbGoodServiceImp goodService;
    //查询数据有多少条
    @RequestMapping("/findAll")
    public Integer findAll(){
        return goodService.findAll().size();
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
//    @RequestMapping("/add")
//    public void add(String name, String typId, Integer orderNo, Integer sellNum,
//                    MultipartFile file, MultipartFile file1, MultipartFile file2,
//                    String tag, String zonId, String copyDesc, String forwardLink){
//        System.out.println(file+"*****"+file1+"********"+file2);
//        WxbGood wxbGood =new WxbGood();
//        wxbGood.setGoodName(name);
//        wxbGood.setTypeId(typId);
//        wxbGood.setOrderNo(orderNo);
//        wxbGood.setSellNum(sellNum);
//        wxbGood.setTags(tag);
//        wxbGood.setZonId(zonId);
//        wxbGood.setCopyDesc(copyDesc);
//        wxbGood.setForwardLink(forwardLink);
//        goodService.insert(wxbGood,file,file1,file2);
//    }
    @RequestMapping("/add")
    public void add(WxbGood wxbGood,MultipartFile file, MultipartFile file1, MultipartFile file2){
        goodService.insert(wxbGood,file,file1,file2);
    }
}
