package com.king.demo.goods.rs.server;

import com.king.demo.goods.api.controller.IApiGoodsOperateController;
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
    String result = goodsOperateController.querybyid();
    return result;
  }

  @Override
  public String add(RsGoods goods) throws Exception {
    System.out.println("add:"+goods);
    String result = goodsOperateController.add();
    return result;
  }

  @Override
  public String delete(String id) throws Exception {
    System.out.println("delete:"+id);
    String result = goodsOperateController.delete();
    return result;
  }

  @Override
  public String update(RsGoods goods) throws Exception {
    System.out.println("update:"+goods);
    String result = goodsOperateController.update();
    return result;
  }

}
