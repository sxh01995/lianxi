package com.lianxi.service.good;

import com.lianxi.dao.goodDao.WxbGoodDao;
import com.lianxi.entity.good.WxbGood;
import com.lianxi.utill.Constant;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//商品信息
@Service
public class WxbGoodServiceImp{
    @Resource
    private WxbGoodDao goodDao;
    //查询所有
    public List<WxbGood> findAll(){
        return goodDao.findAll();
    }
    //添加
    public String insert(WxbGood wxbGood, MultipartFile file, MultipartFile file1, MultipartFile file2){
        try {
            if (file != null) {
                String s = UUID.randomUUID().toString().replaceAll("-", "");
                wxbGood.setGoodPic(s);
                file.transferTo(new File(Constant.PATH + s));
            }
            if (file1 != null) {
                String s1 = UUID.randomUUID().toString().replaceAll("-", "");
                wxbGood.setGoodPic1(s1);
                file1.transferTo(new File(Constant.PATH + s1));
            }
            if (file2 != null) {
                String s2 = UUID.randomUUID().toString().replaceAll("-", "");
                wxbGood.setGoodPic2(s2);
                file2.transferTo(new File(Constant.PATH + s2));
            }
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片添加失败");
            return "0";
        }
        wxbGood.setCreateTime(new Date());
        String[] goodId = UUID.randomUUID().toString().split("-");
        wxbGood.setGoodId(goodId[0]);
        goodDao.insert(wxbGood);
        return "1";
    }
    //根据ID查询
    public WxbGood findById(String goodId){
        return goodDao.findById(goodId);
    }
    //商品信息全表查询分页页数
    public Integer divide(){

        Integer size =findAll().size();
        Integer page=null;
        if(size% Constant.GOOD_PAGING==0){
            page=size/Constant.GOOD_PAGING;
        }else {
            page=size/Constant.GOOD_PAGING+1;
        }
        return page;
    }
    //分页显示
    public  List<WxbGood> paging(Integer index){
        if(index!=null){
            Integer start = start(index);
            return goodDao.paging(start, Constant.GOOD_PAGING);
        }
        return null;
    }
    //分页起始条数
    public Integer start(Integer index){
        return (index-1)*Constant.GOOD_PAGING;
    }
}
