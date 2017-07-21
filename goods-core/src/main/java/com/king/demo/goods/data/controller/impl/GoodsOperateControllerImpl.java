package com.king.demo.goods.data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.king.demo.goods.api.controller.IApiGoodsOperateController;
import com.king.demo.goods.api.parameter.ApiGoods;
import com.king.demo.goods.data.domain.Goods;
import com.king.demo.goods.data.service.IGoodsOperateService;

public class GoodsOperateControllerImpl implements IApiGoodsOperateController {

  @Autowired
  private IGoodsOperateService goodsOperateServiceImpl;

  @Override
  public String queryall() throws Exception {
    String result = goodsOperateServiceImpl.queryall();
    return result;
  }

  @Override
  public String querybyid(String id) throws Exception {
    String result = goodsOperateServiceImpl.querybyid(id);
    return result;
  }

  @Override
  public String add(ApiGoods goods) throws Exception {
    Goods cgoods = new Goods();
    cgoods.setUuid(goods.getUuid()); // 逻辑主键
    cgoods.setGid(goods.getGid()); // 业务主键 通过序列来生成
    cgoods.setCode(goods.getCode()); // 商品代码
    cgoods.setName(goods.getName()); // 商品名称
    cgoods.setRtlprc(goods.getRtlprc()); // 商品售价
    cgoods.setLastmodifytime(goods.getLastmodifytime()); // 商品最后修改时间
    cgoods.setState(goods.getState()); // 商品状态
    String result = goodsOperateServiceImpl.add(cgoods);
    return result;
  }

  @Override
  public String delete(String id) throws Exception {
    String result = goodsOperateServiceImpl.delete(id);
    return result;
  }

  @Override
  public String update(ApiGoods goods) throws Exception {
    Goods cgoods = new Goods();
    cgoods.setUuid(goods.getUuid()); // 逻辑主键
    cgoods.setGid(goods.getGid()); // 业务主键 通过序列来生成
    cgoods.setCode(goods.getCode()); // 商品代码
    cgoods.setName(goods.getName()); // 商品名称
    cgoods.setRtlprc(goods.getRtlprc()); // 商品售价
    cgoods.setLastmodifytime(goods.getLastmodifytime()); // 商品最后修改时间
    cgoods.setState(goods.getState()); // 商品状态
    String result = goodsOperateServiceImpl.update(cgoods);
    return result;
  }
}
