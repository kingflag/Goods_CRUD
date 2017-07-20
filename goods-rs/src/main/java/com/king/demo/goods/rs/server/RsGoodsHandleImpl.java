package com.king.demo.goods.rs.server;

import java.util.ArrayList;
import java.util.List;

import com.king.demo.goods.rs.service.IRsGoodsHandle;

public class RsGoodsHandleImpl implements IRsGoodsHandle {

  @Override
  public String queryall() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("queryall");
    result.add("china");
    return result.toString();
  }

  @Override
  public String querybyid() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("querybyid");
    result.add("china");
    return result.toString();
  }

  @Override
  public String add() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("add");
    result.add("china");
    return result.toString();
  }

  @Override
  public String delete() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("delete");
    result.add("china");
    return result.toString();
  }

}
