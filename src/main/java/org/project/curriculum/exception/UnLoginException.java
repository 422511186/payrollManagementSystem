package org.project.curriculum.exception;

/**
 *未登录被拦截
 * @Auther: hzy
 * @Date: 2022/2/10 03:24
 * @Description:
 */
public class UnLoginException extends Exception{
    public UnLoginException(String msg) {
        super(msg);
    }
}
