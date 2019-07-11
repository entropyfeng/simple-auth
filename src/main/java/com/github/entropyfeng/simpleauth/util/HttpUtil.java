package com.github.entropyfeng.simpleauth.util;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.security.auth.AuthPermission;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author entropyfeng
 * Http 工具类
 */
public class HttpUtil {

    private static final Logger logger=LoggerFactory.getLogger(HttpUtil.class);


    public static void writeJsonResponse(HttpServletResponse response, String jsonString) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter out = response.getWriter()) {
            out.write(jsonString);
            out.flush();
        } catch (IOException e) {
            logger.warn(e.toString());
        }

    }
    public static String getAuthToken(HttpServletRequest request){

      final String authTokenName =  AuthProperties.authTokenName;

      String authToken= (String)request.getAttribute(authTokenName );
      if(StringUtils.isEmpty(authToken)){
          authToken=(String)request.getParameter(authTokenName );
      }else {
          return authToken;
      }

      if(StringUtils.isEmpty(authToken)){
        authToken= (String) request.getSession().getAttribute(authTokenName );
      }
      return authToken;
    }

    /**
     * 获取用户真实ip地址(不保证获取真实的，可以伪造)
     * @param request {@link HttpServletRequest}
     * @return 用户ip 可能为null
     */
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;
        final String unknown="unknown";
        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (StringUtils.isEmpty(ipAddresses) || unknown.equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddresses) || unknown.equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddresses) || unknown.equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (StringUtils.isEmpty(ipAddresses) || unknown.equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (StringUtils.isEmpty(ip) ||unknown.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
