package com.king.demo.goods.data.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.king.demo.goods.data.dao.IGoodsOperateDao;
import com.king.demo.goods.data.domain.Goods;
import com.king.demo.goods.data.service.IGoodsOperateService;

public class GoodsOperateServiceImpl implements IGoodsOperateService {

  private static final Logger logger = Logger.getLogger(GoodsOperateServiceImpl.class);

  @Autowired
  private IGoodsOperateDao goodsOperateDaoImpl;

  public static <T> String mapToJson(Map<String, T> map) {
    Gson gson = new Gson();
    String jsonStr = gson.toJson(map);
    return jsonStr;
  }

  @Override
  public String queryall() {
    System.out.println("进入service：queryall");
    List<Goods> goods = new ArrayList<Goods>();
    goods = goodsOperateDaoImpl.queryall();
    logger.info("goods:" + goods);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("state", "200");
    result.put("data", "queryall");
    result.put("goods", goods);
    String resultJson = mapToJson(result);
    return resultJson;
  }

  @Override
  public String querybyid(String id) {
    System.out.println("进入service：querybyid" + id);
    Goods good = new Goods();
    good = goodsOperateDaoImpl.querybyid(id);
    logger.info("good:" + good);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("state", "200");
    result.put("data", "querybyid");
    result.put("good", good);
    String resultJson = mapToJson(result);
    return resultJson;
  }

  @Override
  public String add(Goods goods) {
    System.out.println("进入service：add" + goods);
    Goods good = new Goods();
    good = goodsOperateDaoImpl.add(goods);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("state", "200");
    result.put("data", "add");
    result.put("good", good);
    String resultJson = mapToJson(result);
    return resultJson;
  }

  @Override
  public String delete(String id) {
    System.out.println("进入service：delete" + id);
    String removeId = goodsOperateDaoImpl.delete(id);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("state", "200");
    result.put("data", "delete");
    result.put("removeId", removeId);
    String resultJson = mapToJson(result);
    return resultJson;
  }

  @Override
  public String update(Goods goods) {
    System.out.println("进入service：update" + goods);
    Goods good = new Goods();
    good = goodsOperateDaoImpl.add(goods);
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("state", "200");
    result.put("data", "update");
    result.put("good", good);
    String resultJson = mapToJson(result);
    return resultJson;
  }

}
