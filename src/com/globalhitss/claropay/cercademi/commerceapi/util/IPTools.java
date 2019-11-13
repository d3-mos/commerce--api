package com.globalhitss.claropay.cercademi.commerceapi.util;

import javax.servlet.http.HttpServletRequest;

public class IPTools 
{

  public static String getIPFromRequest(HttpServletRequest rq)
  {
    String remoteAddr = "";

    if (rq != null) {
        remoteAddr = rq.getHeader("X-Forwarded-For");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = rq.getRemoteAddr();
        }
    }

    return remoteAddr;
  }
}
