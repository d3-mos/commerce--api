package com.globalhitss.claropay.cercademi.commerceapi.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreLocation;


@Repository
@Qualifier("commerceSQLDAO")
public class CommerceSQLDao implements CommerceDao 
{

  @Autowired
  private SessionFactory sessionFactory;
  
  private Session getSession()
  {
    return sessionFactory.getCurrentSession();
  }

  
  public StoreLocation selectById(int id)
  {
    return getSession().find(StoreLocation.class, id);
  }
  
  
  public List<StoreLocation> selectByLatAndLng(double lat, double lng)
  {
    String querySelect = "from StoreLocation as c "
     + "where sqrt( pow(c.lat - (:lat), 2) + pow(c.lng - (:lng), 2) ) < 0.02";
    
    Query<StoreLocation> query = getSession().createQuery(querySelect, StoreLocation.class);
    query.setParameter("lat", lat);
    query.setParameter("lng", lng);
    
    return query.getResultList();
  }
  
  
  public List<StoreLocation> selectByBrand(String brandToken)
  {
    String querySelect = "from StoreLocation as c where c.brand = (:brandToken)";
    
    Query<StoreLocation> query = getSession().createQuery(querySelect, StoreLocation.class);
    query.setParameter("brandToken", brandToken);
    
    return query.getResultList();
  }
  
  public List<StoreLocation> selectByClass(String className)
  {
    String querySelect = "from StoreLocation as c where c.className = (:className)";
    
    Query<StoreLocation> query = getSession().createQuery(querySelect, StoreLocation.class);
    query.setParameter("className", className);
    
    return query.getResultList();
  }
}
