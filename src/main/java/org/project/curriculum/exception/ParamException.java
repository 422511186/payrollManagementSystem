package org.project.curriculum.exception;

/**
 * 参数缺失异常
 * @Auther: hzy
 * @Date: 2022/2/10 01:24
 * @Description:
 */
public class ParamException extends Exception{
    public ParamException(String msg) {
        super(msg);
    }
}
