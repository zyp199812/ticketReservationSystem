package com.zn.ticketreservationsystem.config;

import com.zn.ticketreservationsystem.dmoain.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @Author: ZN_nick
 * @Date: 2018/11/4 12:47
 * @Version 1.0
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations. Interceptors can be registered to apply
     * to all requests or be limited to a subset of URL patterns.
     * <p><strong>Note</strong> that interceptors registered here only apply to
     * controllers and not to resource handler requests. To intercept requests for
     * static resources either declare a
     * {@link MappedInterceptor MappedInterceptor}
     * bean or switch to advanced configuration mode by extending
     * {@link WebMvcConfigurationSupport
     * WebMvcConfigurationSupport} and then override {@code resourceHandlerMapping}.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/user");
        list.add("/ticket");
        registry.addInterceptor(new SessionHandleInterceptor()).addPathPatterns(list);
    }
    class SessionHandleInterceptor implements HandlerInterceptor{
        /**
         * Intercept the execution of a handler. Called after HandlerMapping determined
         * an appropriate handler object, but before HandlerAdapter invokes the handler.
         * <p>DispatcherServlet processes a handler in an execution chain, consisting
         * of any number of interceptors, with the handler itself at the end.
         * With this method, each interceptor can decide to abort the execution chain,
         * typically sending a HTTP error or writing a custom response.
         * <p><strong>Note:</strong> special considerations apply for asynchronous
         * request processing. For more details see
         * {@link AsyncHandlerInterceptor}.
         * <p>The default implementation returns {@code true}.
         *
         * @param request  current HTTP request
         * @param response current HTTP response
         * @param handler  chosen handler to execute, for type and/or instance evaluation
         * @return {@code true} if the execution chain should proceed with the
         * next interceptor or the handler itself. Else, DispatcherServlet assumes
         * that this interceptor has already dealt with the response itself.
         * @throws Exception in case of errors
         */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            User user = (User) request.getSession().getAttribute("userId");
            if (user == null){
//                如果没有登录则重定向至登录
                response.sendRedirect("/login");
                return false;
            }
            return true;

        }


    }
}
