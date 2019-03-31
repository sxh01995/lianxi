package com.lianxi.entity.user;

import lombok.Data;

@Data
//角色表
public class SysRole {
  //角色编码
  private String roleCode;
  //角色名称
  private String roleName;
  //角色描述
  private String roleDesc;
  //角色排序
  private Integer roleOrder;
  //角色类型 1:业务角色;2:管理角色;
  private Integer roleType;
}
