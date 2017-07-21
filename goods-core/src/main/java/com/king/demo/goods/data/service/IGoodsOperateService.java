package com.king.demo.goods.data.service;

import com.king.demo.goods.data.domain.Goods;

public interface IGoodsOperateService {

  public String queryall();

  public String querybyid(String id);

  public String add(Goods goods);

  public String delete(String id);

  public String update(Goods goods);
}
