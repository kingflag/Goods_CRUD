package com.king.demo.goods.api.parameter;

import java.math.BigDecimal;
import java.util.Date;

public class ApiGoods {
  private String uuid; // 逻辑主键
  private Integer gid; // 业务主键 通过序列来生成
  private String code; // 商品代码
  private String name; // 商品名称
  private BigDecimal rtlprc; // 商品售价
  private Date lastmodifytime; // 商品最后修改时间
  private String state; // 商品状态

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public Integer getGid() {
    return gid;
  }

  public void setGid(Integer gid) {
    this.gid = gid;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getRtlprc() {
    return rtlprc;
  }

  public void setRtlprc(BigDecimal rtlprc) {
    this.rtlprc = rtlprc;
  }

  public Date getLastmodifytime() {
    return lastmodifytime;
  }

  public void setLastmodifytime(Date lastmodifytime) {
    this.lastmodifytime = lastmodifytime;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "ApiGoods [uuid=" + uuid + ", gid=" + gid + ", code=" + code + ", name=" + name
        + ", rtlprc=" + rtlprc + ", lastmodifytime=" + lastmodifytime + ", state=" + state + "]";
  }
  
}
