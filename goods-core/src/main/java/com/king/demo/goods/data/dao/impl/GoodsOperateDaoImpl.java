package com.king.demo.goods.data.dao.impl;

import java.math.BigDecimal;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;

import com.king.demo.goods.data.dao.GoodsOperateDao;
import com.king.demo.goods.data.domain.Goods;

public class GoodsOperateDaoImpl implements GoodsOperateDao, ApplicationContextAware {

  protected ApplicationContext appCtx;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.appCtx = applicationContext;
  }

  /** 获得一个EntityManagerFactory。 */
  protected EntityManager createEntityManager() throws IllegalStateException {
    EntityManagerFactory emf = null;
    try {
      emf = appCtx.getBean("goods-core.emf", EntityManagerFactory.class);
    } catch (Exception e) {
      System.out.println("发生异常");
    }
    return emf.createEntityManager();
  }

  private JdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public GoodsOperateDaoImpl() {
    System.out.println("This is GoodsOperateDaoImpl construction");
  }

  @Override
  public String test() {

    EntityManager em = createEntityManager();
    try {
      Goods goods = new Goods();
      goods.setGid(232);
      goods.setCode("test(((00");
      goods.setName("myname");
      goods.setRtlprc( new BigDecimal(Double.toString(69.48)));
      goods.setLastmodifytime(new Date());
      goods.setState("lllll");
      em.getTransaction().begin();
      goods = em.merge(goods);
      em.flush();
      em.getTransaction().commit();
      //return goods; 
      System.out.println("goods:"+goods);
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
