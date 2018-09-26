package com.o2o.until;

import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanke on 2018/9/25.
 */
public class VerifyCodeUntil {
    public static boolean isYang(HttpServletRequest request){
        String kaptchaExpected = (String)request.getSession()
                .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String VerifyCodeActual=HttpServletRequestUntil.getString(request,"VerifyCodeActual");
        if(VerifyCodeActual!=null&&kaptchaExpected.equals(VerifyCodeActual)){
            return true;
        }else{
            return  false;
        }
    }

}
