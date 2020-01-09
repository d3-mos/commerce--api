package com.globalhitss.claropay.cercademi.restapi.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.globalhitss.claropay.cercademi.restapi.model.StoreLocation;

import org.hibernate.query.Query;



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
  public List<StoreLocation> selectByLatAndLng(double latKm, double lngKm, double vRadius)
  {
    String querySelect = "from StoreLocation where "
     + "sqrt( pow(latKm - (:latKm), 2) + pow(lngKm - (:lngKm), 2) ) < (:vRadius)";
    
    Query<StoreLocation> query = getQuery(querySelect);
    query.setParameter("latKm", latKm);
    query.setParameter("lngKm", lngKm);
    query.setParameter("vRadius", vRadius);
    
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
