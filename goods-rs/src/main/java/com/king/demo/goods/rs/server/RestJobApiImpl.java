package com.king.demo.goods.rs.server;

import java.util.ArrayList;
import java.util.List;

import om.king.demo.goods.rs.service.RestJobApi;

public class RestJobApiImpl implements RestJobApi {

  @Override
  public String test() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("lov");
    result.add("china");
    return result.toString();
  }

}
