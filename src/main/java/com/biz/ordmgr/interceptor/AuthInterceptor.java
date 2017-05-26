package com.biz.ordmgr.interceptor;

import com.alibaba.fastjson.JSON;
import com.biz.ordmgr.auth.AuthPassport;
import com.biz.ordmgr.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器.
 * @author Richard Liu
 * @version $Id$
 * @since 2017.03.30
 */
public final class AuthInterceptor implements HandlerInterceptor {

    /**
     * 登录url.
     */
    private static final String LOGIN_URL = "/common/login";

    /**
     * Logger.
     */
    private static final Logger LOGGER =
        LoggerFactory.getLogger(AuthInterceptor.class);
//    @Override
    public boolean preHandle(final HttpServletRequest request,
        final HttpServletResponse response, final Object handler)
        throws Exception {
//        LOGGER.info("request.getContextPath() = {}", request.getContextPath());
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            final AuthPassport authPassport =
                ((HandlerMethod) handler).getMethodAnnotation(
                    AuthPassport.class
                );
//            LOGGER.info("authPassport is {}", JSON.toJSONString(authPassport));
            if (authPassport == null)
                return true;
            else {
                final HttpSession session = request.getSession();
                if (null == session) {
                    response.sendRedirect(request.getContextPath() + AuthInterceptor.LOGIN_URL);
                    return false;
                }
                User user = (User) session.getAttribute("user");
                LOGGER.info("logged in user is {}", user);
                if (null == user) {
                    response.sendRedirect(request.getContextPath() + AuthInterceptor.LOGIN_URL);
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        else {
            return true;
        }
    }

//    @Override
    public void postHandle(final HttpServletRequest request,
        final HttpServletResponse response, final Object handler,
        final ModelAndView modelAndView) throws Exception {

    }

//    @Override
    public void afterCompletion(final HttpServletRequest request,
        final HttpServletResponse response, final Object handler,
        final Exception ex) throws Exception {

    }
}
