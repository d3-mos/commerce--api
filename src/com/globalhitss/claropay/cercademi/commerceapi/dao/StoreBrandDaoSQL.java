package com.globalhitss.claropay.cercademi.commerceapi.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreBrand;

@Repository
@Qualifier("StoreBrandDaoSQL")
public class StoreBrandDaoSQL implements StoreBrandDao{
  @Autowired
  private SessionFactory sessionFactory;
  
  private Session getSession()
  {
    return sessionFactory.getCurrentSession();
  }

  private Query<StoreBrand> getQuery(String hqlSentence)
  {
    return getSession().createQuery(hqlSentence, StoreBrand.class);
  }
  
  public List<StoreBrand> getAll()
  { 
    List<StoreBrand> brands = getQuery("from StoreBrand").getResultList();
    brands.forEach(brand -> {
      Hibernate.initialize(brand.getOperations());
      Hibernate.initialize(brand.getPromotions());
    });
    return brands;
  }
}
