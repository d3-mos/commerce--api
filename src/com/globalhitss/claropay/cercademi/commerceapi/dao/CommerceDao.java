package com.globalhitss.claropay.cercademi.commerceapi.dao;

import com.globalhitss.claropay.cercedemi.commerceapi.model.Commerce;


public interface CommerceDao 
{
  Commerce findBySpecies(String species);
}
