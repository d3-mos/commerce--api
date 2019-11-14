package com.globalhitss.claropay.cercademi.commerceapi.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import com.globalhitss.claropay.cercedemi.commerceapi.model.CommerceModel;


@Repository
public class CommerceSQLDao {

  @Autowired
  private SessionFactory sessionFactory;
  
  private Session getSession()
  {
    return sessionFactory.getCurrentSession();
  }

  
  public CommerceModel selectById(int id)
  {
    return getSession().find(CommerceModel.class, id);
  }
  
  
  public List<CommerceModel> selectByLatAndLng(double lat, double lng)
  {
    String querySelect = "from CommerceModel as c "
     + "where sqrt( pow(c.lat - (:lat), 2) + pow(c.lng - (:lng), 2) ) < 0.02";
    
    Query<CommerceModel> query = getSession().createQuery(querySelect, CommerceModel.class);
    query.setParameter("lat", lat);
    query.setParameter("lng", lng);
    
    return query.getResultList();
  }
  
  
  public List<CommerceModel> selectBySpecies(String species)
  {
    String querySelect = "from CommerceModel as c where c.species = (:species)";
    
    Query<CommerceModel> query = getSession().createQuery(querySelect);
    query.setParameter("species", species);
    
    return query.getResultList();
  }
  
  public List<CommerceModel> selectByClass(String className)
  {
    String querySelect = "from CommerceModel as c where c.className = (:className)";
    
    Query<CommerceModel> query = getSession().createQuery(querySelect);
    query.setParameter("className", className);
    
    return query.getResultList();
  }
}
