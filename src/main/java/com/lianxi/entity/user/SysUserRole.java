package com.lianxi.entity.user;

import lombok.Data;

@Data
//用户角色表
public class SysUserRole {
  private Integer id;
  private String userId;
  private String roleId;
}
