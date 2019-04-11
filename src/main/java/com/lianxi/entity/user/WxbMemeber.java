package com.lianxi.entity.user;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class WxbMemeber {
  //会员主键
  private String memeberId;
  //账号
  private String account;
  //QQ号码
  private String qqNum;
  //邮箱
  private String email;
  //手机号码
  private String phone;
  //推荐人ID 默认管理员
  private String recomUser;
  //注册时间
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date registerTime;
  //支付宝账号
  private String payAccount;
  //姓名
  private String name;
  //密码
  private String password;
  //邀请码
  private String visitCode;
  //是否有邀请权限 0 没有 1 有
  private long useRecom;
  //层级关系识别码
  private String levelCode;
  //MID
  private long mid;
  //最后登录时间
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;
  //盐
  private String memeberSalt;

}
