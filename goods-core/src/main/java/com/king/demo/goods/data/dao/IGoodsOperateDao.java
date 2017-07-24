package com.king.demo.goods.data.dao;

import java.util.List;

import com.king.demo.goods.data.domain.Goods;

public interface IGoodsOperateDao {

  public String test();

  public List<Goods> queryall();

  public Goods querybyid(String id);

  public Goods add(Goods goods);

  public String delete(String id);

  public Goods update(Goods goods);
  
  public Goods check(String id);
  
  
}
