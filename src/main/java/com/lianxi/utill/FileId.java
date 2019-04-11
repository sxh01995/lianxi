package com.lianxi.utill;

import com.lianxi.entity.good.WxbGood;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Component
public class FileId {
    public WxbGood imgId(WxbGood wxbGood, MultipartFile file, MultipartFile file1, MultipartFile file2) throws IOException {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        file.transferTo(new File(Constant.PATH + s));
        String s1 = UUID.randomUUID().toString().replaceAll("-", "");
        file1.transferTo(new File(Constant.PATH + s1));
        String s2 = UUID.randomUUID().toString().replaceAll("-", "");
        file2.transferTo(new File(Constant.PATH + s2));
        wxbGood.setGoodPic(s);
        wxbGood.setGoodPic1(s1);
        wxbGood.setGoodPic2(s2);
        return wxbGood;
    }
}
