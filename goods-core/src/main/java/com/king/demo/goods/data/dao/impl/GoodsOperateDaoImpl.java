package com.king.demo.goods.data.dao.impl;

import java.math.BigDecimal;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;

import com.king.demo.goods.data.dao.IGoodsOperateDao;
import com.king.demo.goods.data.domain.Goods;

public class GoodsOperateDaoImpl implements IGoodsOperateDao, ApplicationContextAware {

  protected ApplicationContext appCtx;

  private static final Logger logger = Logger.getLogger(GoodsOperateDaoImpl.class);

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
      e.printStackTrace();
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
      goods.setRtlprc(new BigDecimal(Double.toString(69.48)));
      goods.setLastmodifytime(new Date());
      goods.setState("lllll");
      em.getTransaction().begin();
      goods = em.merge(goods);
      em.flush();
      em.getTransaction().commit();
      // return goods;
      System.out.println("goods:" + goods);
      System.out.println("7878");
      DatabaseMetaData md = this.jdbcTemplate.getDataSource().getConnection().getMetaData();
      System.out.println(md.getDatabaseProductName());
      System.out.println(md.getDatabaseProductVersion());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return "GoodsOperateDaoImpl Test";

  }

  @Override
  public List<Goods> queryall() {
    List<Goods> result = new ArrayList<Goods>();
    EntityManager em = createEntityManager();
    try {
      String hql = "from " + Goods.class.getName();
      Query query = em.createQuery(hql);
      result = query.getResultList();
      logger.info("result:" + result);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
    }
    return result;
  }

  @Override
  public Goods querybyid(String id) {
    Goods result = new Goods();
    EntityManager em = createEntityManager();
    try {
      String hql = "from " + Goods.class.getName() + " where uuid = :id";
      Query query = em.createQuery(hql);
      query.setParameter("id", id);
      result = (Goods) query.getSingleResult();
      logger.info("result:" + result);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
    }
    return result;
  }

  @Override
  public Goods add(Goods goods) {
    logger.debug("enter add");
    EntityManager em = createEntityManager();
    try {
      em.getTransaction().begin();
      goods = em.merge(goods);
      em.flush();
      em.getTransaction().commit();
      return goods;
    } catch (Exception e) {
      logger.warn(e.getMessage());
      try {
        em.getTransaction().rollback();
      } catch (Exception ex) {
      }
      em.clear();
    } finally {
      em.close();
    }
    return null;
  }

  @Override
  public String delete(String id) {

    EntityManager em = createEntityManager();
    try {
      em.getTransaction().begin();
      Goods p = em.find(Goods.class, id);
      em.remove(p);// 删除的bean对象也必须是处于托管状态的对象才能被删除成功。
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      logger.info("delete errer:" + id);
      id = null;
    } finally {
      em.close();
    }
    return id;

  }

  @Override
  public Goods update(Goods goods) {
    logger.debug("enter update");
    EntityManager em = createEntityManager();
    try {
      em.getTransaction().begin();
      goods = em.merge(goods);
      em.flush();
      em.getTransaction().commit();
      return goods;
    } catch (Exception e) {
      logger.warn(e.getMessage());
      try {
        em.getTransaction().rollback();
      } catch (Exception ex) {
      }
      em.clear();
    } finally {
      em.close();
    }
    return null;
  }

  @Override
  public Goods check(String id) {
    System.out.println("check:" + id);
    logger.debug("enter update");
    Goods goods = new Goods();
    EntityManager em = createEntityManager();
    try {
      goods = querybyid(id);
      if (goods == null) {
        logger.info("不存在此对象");
      } else {
        em.getTransaction().begin();
        logger.info("取得id:"+id);
        Query query = em.createNativeQuery("{call Goods_state_update(?)}");
        query.setParameter(1, id);
        query.executeUpdate();
        logger.info("调用存储过程：" + query);
      }
      em.getTransaction().commit();
      em.clear();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
    }

    return goods;
  }

}
