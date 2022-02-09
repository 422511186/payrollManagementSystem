package org.project.curriculum.exception;


import lombok.extern.slf4j.Slf4j;
import org.project.curriculum.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * 全部异常处理
 * <p>
 * 处理整个web controller的异常
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {



    /**
     * 未登录拦截后返回值
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UnLoginException.class)
    public Result handleUnLoginException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(403,"FAIL",e.getMessage());
        return result;
    }

    /**
     * 参数缺失异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ParamException.class)
    public Result handleParamException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(400, "Fail",e.getMessage());
        return result;
    }
    /**
     * 处理业务操作失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(FailException.class)
    public Result handleFailException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(503, "Fail");
        result.setData(e.getMessage());
        return result;
    }
    /**
     * 登录操作失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(LoginException.class)
    public Result handleLoginException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(403, "Fail");
        result.setData(e.getMessage());
        return result;
    }
    /**
     * 数据库异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public Result handleSQLException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(500, "ERROR");
        result.setData(e.toString());
        return result;
    }

    /**
     * 处理空指针异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public Result handleNullPointerException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(504, "ERROR","出异常了,请检查参数是否完整");
        return result;
    }

    /**
     * 处理其他异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result= new Result<>(10086, "ERROR","出现未知异常啦!请联系管理员查看日志。");
        return result;
    }


}
