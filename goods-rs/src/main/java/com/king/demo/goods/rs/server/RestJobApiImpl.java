package com.king.demo.goods.rs.server;

import java.util.ArrayList;
import java.util.List;

import com.king.demo.goods.rs.service.IRestJobApi;

public class RestJobApiImpl implements IRestJobApi {

  @Override
  public String test() throws Exception {
    List<String> result = new ArrayList<String>();
    result.add("love");
    result.add("china");
    return result.toString();
  }

}
