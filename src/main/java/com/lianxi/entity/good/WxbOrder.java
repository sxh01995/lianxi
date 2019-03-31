package com.lianxi.entity.good;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
//订单表
public class WxbOrder {
  //ID
  private Integer oid;
  //订单编号
  private String orderId;
  //买家电话
  private String buyerPhone;
  //商品编号
  private String goodId;
  //下单时间
  private Date orderTime;
  //渠道编号
  private String channelId;
  //状态
  private Integer state;
  //购买数量
  private Integer buyNum;
  //省份
  private String province;
  //市
  private String city;
  //地区
  private String area;
  //留言
  private String buyerReamrk;
  //支付方式
  private Integer payType;
  //买家姓名
  private String buyerName;
  //选择的套餐
  private String skuId;
  //代理用户
  private String userId;
  //详细地址
  private String address;
  //快递单号
  private String courierId;
  //备注信息
  private String orderRemark;
  //快递公司
  private String senderType;
  //0 正常下单 1 代客录单 2 异常订单
  private Integer orderType;
  //后台备注
  private String adminRemark;
  //审核人员
  private String operator;
  //订单审核时间
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date checkTime;
  //下单IP
  private String orderIp;
  //最后修改时间
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;
  //支付宝支付状态，未支付为0，已支付为1
  private String alipayState;
  private Integer isfk;
  private Integer kdzt;
  private String miaoshu;
}
