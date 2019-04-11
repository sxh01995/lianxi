package com.lianxi.service.good.Imp;

import com.lianxi.dao.goodDao.WxbGoodDao;
import com.lianxi.entity.good.WxbGood;
import com.lianxi.service.good.WxbGoodService;
import com.lianxi.utill.Constant;
import com.lianxi.utill.FileId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//商品信息
@Service
public class WxbGoodServiceImp implements WxbGoodService{
    @Resource
    private WxbGoodDao goodDao;
    //帮助类，上传照片，并获取照片ID填入wxbGood中
    @Autowired
    private FileId fileId;
    //查询所有
    public List<WxbGood> findAll(){
        List<WxbGood> all = goodDao.findAll();
        System.out.println(all.size());
        return all;
    }
    //添加
    public String insert(WxbGood wxbGood1, MultipartFile file, MultipartFile file1, MultipartFile file2){
        try {
            WxbGood wxbGood = fileId.imgId(wxbGood1, file, file1, file2);
            //添加时间
            wxbGood.setCreateTime(new Date());
            //生成此条数据的唯一id
            String[] goodId = UUID.randomUUID().toString().split("-");
            wxbGood.setGoodId(goodId[0]);
            goodDao.insert(wxbGood);
            return "1";
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片添加失败");
            return "0";
        }
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
