package com.king.demo.goods.data.test;

import org.junit.Test;

public class GoodsTest {

  @Test
  public void Testqueryall() {
    String result = null;
    String url = "http://localhost:8080/goods-server/rest/core/goodshandle/queryall";
    String charset = "utf-8";
    result = HTTPUtils.doGet(url, charset);
    System.out.println("result:" + result);
  }
  
  @Test
  public void Testquerybyid() {
    String result = null;
    String id = "2c9184945d725b29015d725f62790001";
    String url = "http://localhost:8080/goods-server/rest/core/goodshandle/querybyid/"+id;
    String charset = "utf-8";
    result = HTTPUtils.doGet(url, charset);
    System.out.println("result:" + result);
  }
  
  

}
