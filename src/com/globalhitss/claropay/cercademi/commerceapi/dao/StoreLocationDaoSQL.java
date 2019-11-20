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
@Qualifier("StoreLocationDaoSQL")
public class StoreLocationDaoSQL implements StoreLocationDao 
{

  @Autowired
  private SessionFactory sessionFactory;
  
  private Session getSession()
  {
    return sessionFactory.getCurrentSession();
  }

  private Query<StoreLocation> getQuery(String hqlSentence)
  {
    return getSession().createQuery(hqlSentence, StoreLocation.class);
  }
  
  
  /***/
  public StoreLocation selectById(int id)
  {
    return getSession().find(StoreLocation.class, id);
  }
  
  /***/
  public List<StoreLocation> selectByLatAndLng(double lat, double lng)
  {
    String querySelect = "from StoreLocation where "
     + "sqrt( pow(lat - (:lat), 2) + pow(lng - (:lng), 2) ) < 0.02";
    
    Query<StoreLocation> query = getQuery(querySelect);
    query.setParameter("lat", lat);
    query.setParameter("lng", lng);
    
    return query.getResultList();
  }
  
  /***/
  public List<StoreLocation> selectByBrand(String brandToken)
  {
    String querySelect = "from StoreLocation where brandToken = (:brandToken)";
    
    Query<StoreLocation> query = getQuery(querySelect);
    query.setParameter("brandToken", brandToken);
    
    return query.getResultList();
  }
  
  /***/
  public List<StoreLocation> selectByClass(String className)
  {
    String querySelect = "from StoreLocation where className = (:className)";
    
    Query<StoreLocation> query = getQuery(querySelect);
    query.setParameter("className", className);
    
    return query.getResultList();
  }
}
