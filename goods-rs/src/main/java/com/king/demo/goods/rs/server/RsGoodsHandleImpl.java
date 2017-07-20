package com.king.demo.goods.rs.server;

import java.util.ArrayList;
import java.util.List;

import com.king.demo.goods.api.controller.IApiGoodsOperateController;
import com.king.demo.goods.rs.service.IRsGoodsHandle;

public class RsGoodsHandleImpl implements IRsGoodsHandle {

  private IApiGoodsOperateController goodsOperateController;

  public IApiGoodsOperateController  getgoodsOperateController() {
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
  public String querybyid() throws Exception {
    String result = goodsOperateController.querybyid();
    return result;
  }

  @Override
  public String add() throws Exception {
    String result = goodsOperateController.add();
    return result;
  }

  @Override
  public String delete() throws Exception {
    String result = goodsOperateController.delete();
    return result;
  }

}
