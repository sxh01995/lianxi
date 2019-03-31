package com.lianxi.entity.user;

import lombok.Data;

@Data
//权限功能表
public class SysModule {
  //菜单编号
  private String moduleId;
  //菜单编码
  private String moduleCode;
  //功能名称
  private String moduleName;
  //请求路径
  private String linkUrl;
  //排序编号
  private long moduleOrder;
  //上级功能
  private String parentModule;
  //权限描述
  private String moduleDesc;
  //是否展开
  private String expanded;
  //是否叶子节点
  private String leaf;
}
