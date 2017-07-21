package com.king.demo.goods.api.controller;

import com.king.demo.goods.api.parameter.ApiGoods;

public interface IApiGoodsOperateController {

  public String queryall() throws Exception;

  public String querybyid(String id) throws Exception;

  public String add(ApiGoods goods) throws Exception;

  public String delete(String id) throws Exception;

  public String update(ApiGoods goods) throws Exception;
}
