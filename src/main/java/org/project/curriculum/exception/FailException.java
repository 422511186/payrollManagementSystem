package org.project.curriculum.exception;

/**
 * 业务失败异常
 * @Auther: hzy
 * @Date: 2022/2/8 18:53
 * @Description:
 */

public class FailException extends Exception {

    public FailException(String msg)
    {
        super(msg);
    }
}
