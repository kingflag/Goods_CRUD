package com.king.demo.goods.data.controller.impl;

import java.util.ArrayList;
import java.util.List;

import com.king.demo.goods.api.controller.IApiGoodsOperateController;

public class GoodsOperateControllerImpl implements IApiGoodsOperateController {

  @Override
  public String queryall() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("controller queryall");
    result.add("china");
    return result.toString();
  }

  @Override
  public String querybyid() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("controller querybyid");
    result.add("china");
    return result.toString();
  }

  @Override
  public String add() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("controller add");
    result.add("china");
    return result.toString();
  }

  @Override
  public String delete() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("controller delete");
    result.add("china");
    return result.toString();
  }
}
