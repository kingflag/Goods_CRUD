package com.king.demo.goods.data.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = Goods.TABLE_NAME)
@org.hibernate.annotations.Table(appliesTo = Goods.TABLE_NAME)
public class Goods implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /** 数据库表名称。 */
  public static final String TABLE_NAME = "KINGTESTGOODS";

  private String uuid; // 逻辑主键
  private Integer gid; // 业务主键 通过序列来生成
  private String code; // 商品代码
  private String name; // 商品名称
  private BigDecimal rtlprc; // 商品售价
  private Date lastmodifytime; // 商品最后修改时间
  private String state; // 商品状态

  /**
   * 唯一标识 | 不能为空 | PK。
   */
  @Id
  @Column(name = "uuid", length = 64, nullable = false)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  @Column(name = "gid")
  public Integer getGid() {
    return gid;
  }

  public void setGid(Integer gid) {
    this.gid = gid;
  }

  @Column(name = "code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "rtlprc")
  public BigDecimal getRtlprc() {
    return rtlprc;
  }

  public void setRtlprc(BigDecimal rtlprc) {
    this.rtlprc = rtlprc;
  }

  @Column(name = "lastmodifytime")
  public Date getLastmodifytime() {
    return lastmodifytime;
  }

  public void setLastmodifytime(Date lastmodifytime) {
    this.lastmodifytime = lastmodifytime;
  }

  @Column(name = "state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
