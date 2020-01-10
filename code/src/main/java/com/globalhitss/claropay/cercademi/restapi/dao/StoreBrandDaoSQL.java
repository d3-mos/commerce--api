package com.globalhitss.claropay.cercademi.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.globalhitss.claropay.cercademi.restapi.model.StoreBrand;

@Repository
@Qualifier("StoreBrandDaoSQL")
public class StoreBrandDaoSQL implements StoreBrandDao
{
  @Autowired
  private EntityManager entityManager;

  private Session getSession() {
      return entityManager.unwrap(Session.class);
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
