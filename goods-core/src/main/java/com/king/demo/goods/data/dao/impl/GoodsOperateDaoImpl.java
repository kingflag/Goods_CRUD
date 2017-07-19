package com.king.demo.goods.data.dao.impl;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.king.demo.goods.data.dao.GoodsOperateDao;

public class GoodsOperateDaoImpl implements GoodsOperateDao {

  private JdbcTemplate jdbcTemplate;


  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public GoodsOperateDaoImpl() {
    System.out.println("This is GoodsOperateDaoImpl construction");
  }

  @Override
  public String test() {

    try {
      System.out.println("7878");
      DatabaseMetaData md = this.jdbcTemplate.getDataSource().getConnection().getMetaData();
      System.out.println(md.getDatabaseProductName());
      System.out.println(md.getDatabaseProductVersion());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return "GoodsOperateDaoImpl Test";

  }

}
