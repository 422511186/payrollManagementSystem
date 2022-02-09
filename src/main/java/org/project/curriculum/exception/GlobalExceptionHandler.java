package org.project.curriculum.exception;


import lombok.extern.slf4j.Slf4j;
import org.project.curriculum.utils.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 处理业务操作失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(FailException.class)
    public Result handleFailException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(460, e.getMessage());
        return result;
    }

    /**
     * 数据库插入数据失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(500, e.getMessage());
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
        Result<String> result = new Result<>(500, "出异常了,空指针");
        result.setData(e.toString());
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
        Result<String> result = new Result<>(500, "出现未知异常啦!请联系管理员查看日志。");
        result.setData(e.toString());
        return result;
    }

    /**
     * 处理算术异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ArithmeticException.class})
    public Result handleArithException(Exception e) {
        log.error("异常是：{}", e.toString());
        Result<String> result = new Result<>(500, "出异常了");
        result.setData(e.toString());
        return result;
    }
}
