package org.project.curriculum.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.project.curriculum.exception.LoginException;
import org.project.curriculum.exception.UnLoginException;
import org.project.curriculum.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 登录检查
 * 1、配置好拦截器要拦截哪些请求
 * 2、把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

//    private final ObjectMapper objectMapper;
//
//    /**
//     * 构造器初始化变量
//     */
//    public LoginInterceptor() {
//        System.out.println("objectMapper 初始化");
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        objectMapper = builder.createXmlMapper(false).build();
//    }

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}",requestURI);

        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            //放行
            return true;
        }

        throw new UnLoginException("未登录，请登陆后重新访问");

//        Result<Object> result = new Result<>(403,"FAIL","未登录，请登陆后重新访问");
//        response.setContentType("application/json;charset=utf-8");
//        response.setStatus(200);
//        PrintWriter writer = response.getWriter();
//
//        writer.print(objectMapper.writeValueAsString(result));
//        return false;
    }

    /**
     * 目标方法执行完成以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }

    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);
    }
}
