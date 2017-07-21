package com.king.demo.goods.rs.server;

import java.math.BigDecimal;
import java.util.Date;

import com.king.demo.goods.api.controller.IApiGoodsOperateController;
import com.king.demo.goods.api.parameter.ApiGoods;
import com.king.demo.goods.rs.parameter.RsGoods;
import com.king.demo.goods.rs.service.IRsGoodsHandle;

public class RsGoodsHandleImpl implements IRsGoodsHandle {

  private IApiGoodsOperateController goodsOperateController;

  public IApiGoodsOperateController getgoodsOperateController() {
    return goodsOperateController;
  }

  public void setgoodsOperateController(IApiGoodsOperateController goodsOperateController) {
    this.goodsOperateController = goodsOperateController;
  }

  @Override
  public String queryall() throws Exception {
    String result = goodsOperateController.queryall();
    return result;
  }

  @Override
  public String querybyid(String id) throws Exception {
    System.out.println("querybyid:"+id);
    String result = goodsOperateController.querybyid(id);
    return result;
  }

  @Override
  public String add(RsGoods goods) throws Exception {
    System.out.println("add:"+goods);
    ApiGoods newgoods = new ApiGoods();
    newgoods.setUuid(goods.getUuid()); // 逻辑主键
    newgoods.setGid(goods.getGid()); // 业务主键 通过序列来生成
    newgoods.setCode(goods.getCode()); // 商品代码
    newgoods.setName(goods.getName()); // 商品名称
    newgoods.setRtlprc(goods.getRtlprc()); // 商品售价
    newgoods.setLastmodifytime(goods.getLastmodifytime()); // 商品最后修改时间
    newgoods.setState(goods.getState()); // 商品状态
    String result = goodsOperateController.add(newgoods);
    return result;
  }

  @Override
  public String delete(String id) throws Exception {
    System.out.println("delete:"+id);
    String result = goodsOperateController.delete(id);
    return result;
  }

  @Override
  public String update(RsGoods goods) throws Exception {
    System.out.println("update:"+goods);
    ApiGoods newgoods = new ApiGoods();
    newgoods.setUuid(goods.getUuid()); // 逻辑主键
    newgoods.setGid(goods.getGid()); // 业务主键 通过序列来生成
    newgoods.setCode(goods.getCode()); // 商品代码
    newgoods.setName(goods.getName()); // 商品名称
    newgoods.setRtlprc(goods.getRtlprc()); // 商品售价
    newgoods.setLastmodifytime(goods.getLastmodifytime()); // 商品最后修改时间
    newgoods.setState(goods.getState()); // 商品状态
    String result = goodsOperateController.update(newgoods);
    return result;
  }

}
