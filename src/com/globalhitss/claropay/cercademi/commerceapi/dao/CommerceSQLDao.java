package com.globalhitss.claropay.cercademi.commerceapi.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import com.globalhitss.claropay.cercedemi.commerceapi.model.Commerce;


@Repository
public class CommerceSQLDao implements CommerceDao 
{

  @Autowired
  private SessionFactory sessionFactory;
  
  private Session getSession()
  {
    return sessionFactory.getCurrentSession();
  }

  
  public Commerce selectById(int id)
  {
    return getSession().find(Commerce.class, id);
  }
  
  
  public List<Commerce> selectByLatAndLng(double lat, double lng)
  {
    String querySelect = "from CommerceModel as c "
     + "where sqrt( pow(c.lat - (:lat), 2) + pow(c.lng - (:lng), 2) ) < 0.02";
    
    Query<Commerce> query = getSession().createQuery(querySelect, Commerce.class);
    query.setParameter("lat", lat);
    query.setParameter("lng", lng);
    
    return query.getResultList();
  }
  
  
  public List<Commerce> selectBySpecies(String species)
  {
    String querySelect = "from CommerceModel as c where c.species = (:species)";
    
    Query<Commerce> query = getSession().createQuery(querySelect, Commerce.class);
    query.setParameter("species", species);
    
    return query.getResultList();
  }
  
  public List<Commerce> selectByClass(String className)
  {
    String querySelect = "from CommerceModel as c where c.className = (:className)";
    
    Query<Commerce> query = getSession().createQuery(querySelect, Commerce.class);
    query.setParameter("className", className);
    
    return query.getResultList();
  }
}
