package com.globalhitss.claropay.cercademi.commerceapi.dao;

import com.globalhitss.claropay.cercedemi.commerceapi.model.CommerceModel;


public interface CommerceDao 
{
  CommerceModel findBySpecies(String species);
}
