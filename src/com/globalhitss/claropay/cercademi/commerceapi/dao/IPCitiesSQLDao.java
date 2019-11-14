package com.globalhitss.claropay.cercademi.commerceapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalhitss.claropay.cercedemi.commerceapi.model.IPCities;


@Repository
public class IPCitiesSQLDao implements IPCitiesDao
{
  @Autowired
  private SessionFactory sessionFactory;
	  
  private Session getSession()
  {
    return sessionFactory.getCurrentSession();
  }
  
  public List<IPCities> getLocationByIP(long ip)
  {
    String querySelect = "from IPCities as t "
        + "where t.ipFrom<=(:ip) and t.ipTo>=(:ip) "
        + "order by datasource ASC, noNodes ";
    
    Query<IPCities> query = getSession().createQuery(querySelect,IPCities.class);
    query.setParameter("ip", ip);
    
    return query.getResultList();
  }
}
