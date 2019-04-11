package com.lianxi.service.user.Imp;

import com.lianxi.dao.user.WxbMemeberDao;
import com.lianxi.entity.user.WxbMemeber;
import com.lianxi.service.user.WxbMemeberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WxbMemeberImp implements WxbMemeberService {
    @Resource
    private WxbMemeberDao wxbMemeberDao;
    //用户登陆
    @Override
    public WxbMemeber findDengLu(String account) {
        WxbMemeber dengLu = wxbMemeberDao.findDengLu(account);
        if(dengLu!=null){
            return dengLu;
        }
        return null;
    }
}
