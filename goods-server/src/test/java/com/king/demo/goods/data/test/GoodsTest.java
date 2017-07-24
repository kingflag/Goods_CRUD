package com.king.demo.goods.data.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class GoodsTest {

  @Test
  public void Testqueryall() {
    String result = null;
    String url = "http://localhost:8080/goods-server/rest/core/goodshandle/queryall";
    String charset = "utf-8";
    result = HTTPUtils.doGet(url, charset);
    System.out.println("result:" + result);
  }

  // @Test
  // public void Testquerybyid() {
  // String result = null;
  // String id = "2c9184945d725b29015d725f62790001";
  // String url =
  // "http://localhost:8080/goods-server/rest/core/goodshandle/querybyid/" + id;
  // String charset = "utf-8";
  // result = HTTPUtils.doGet(url, charset);
  // System.out.println("result:" + result);
  // }

  @Test
  public void Testadd() {
    String result = "";
    String url = "http://localhost:8080/goods-server/rest/core/goodshandle/add/";
    String charset = "utf-8";
    Map<String, String> params = new HashMap<String, String>();
    params.put("gid", "966");
    params.put("code", "man");
    params.put("name", "linken");
    params.put("rtlprc", "8.63");
    params.put("lastmodifytime", "2001-07-04T12:08:56.235-0700");
    params.put("state", "state");
    String strparams=new Gson().toJson(params);
    result = HTTPUtils.doPost(url, strparams, charset);
    System.out.println("result:" + result);
  }

}
