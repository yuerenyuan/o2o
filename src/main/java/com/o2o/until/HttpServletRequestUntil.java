package com.o2o.until;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanke on 2018/9/21.
 */
public class HttpServletRequestUntil {
    public static int getInt(HttpServletRequest request,String key){
        try{
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    public static long getLong(HttpServletRequest request,String key){
        try{
            return Long.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    public static double getDouble(HttpServletRequest request,String key){
        try{
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }
    public static boolean getBoolean(HttpServletRequest request,String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }
    public static String getString(HttpServletRequest request,String key){
        try{
            String result=request.getParameter(key);
            if(request!=null){
                result.trim();
            }
            if("".equals(result)){
                result=null;
            }
            return result;
        }catch (Exception e){
            return  null;
        }
    }
}