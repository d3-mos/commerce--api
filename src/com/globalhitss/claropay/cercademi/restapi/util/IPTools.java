package com.globalhitss.claropay.cercademi.restapi.util;

import java.util.LinkedList;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
import static java.lang.Long.parseLong;

import javax.servlet.http.HttpServletRequest;

public class IPTools 
{

  /** */
  private static String completeByte(String byteStr)
  {
    int loop = 8 - byteStr.length();
    String resByteStr = byteStr;

    for (int i=0; i<loop; i++) { resByteStr = "0" + resByteStr; }

    return resByteStr;
  }

  /** */
  private static String ip2ipBin(String ip)
  {
    LinkedList<String> octets = new LinkedList<String>();
    
    for (String octet : ip.split("\\.")) {
      octets.add( completeByte( toBinaryString( parseInt(octet) ) ) );
    }
    
    return String.join("", octets);
  }
  
  /** */
  public static long ip2num(String ip)
  {
    return parseLong( ip2ipBin(ip), 2 );
  }
  
  /** */
  public static String getIPFromHTTPRequest(HttpServletRequest rq)
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
