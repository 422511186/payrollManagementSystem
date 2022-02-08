package org.project.curriculum.exception;


import lombok.extern.slf4j.Slf4j;
import org.project.curriculum.utils.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全部异常处理
 *
 * 处理整个web controller的异常
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(FailException.class)  //处理业务操作失败异常
    public Result handleFailException(Exception e){
        log.error("异常是：{}",e.toString());
        Result<String> result = new Result<>(460,e.getMessage());
        return result;
    }
    @ExceptionHandler(DuplicateKeyException.class)  //数据库插入数据失败异常
    public Result handleDuplicateKeyException(Exception e){
        log.error("异常是：{}",e.toString());
        Result<String> result = new Result<>(500,e.getMessage());
        return result;
    }

    @ExceptionHandler(NullPointerException.class)  //处理空指针异常
    public Result handleNullPointerException(Exception e){
        log.error("异常是：{}",e.toString());
        Result<String> result = new Result<>(500,"出异常了,空指针");
        result.setData(e.toString());
        return result;
    }

    @ExceptionHandler(Exception.class)  //处理其他异常
    public Result handleException(Exception e){
        log.error("异常是：{}",e.toString());
        Result<String> result = new Result<>(500,"出现未知异常啦!请联系管理员查看日志。");
        result.setData(e.toString());
        return result;
    }


    @ExceptionHandler({ArithmeticException.class})  //处理算术异常
    public Result handleArithException(Exception e){
        log.error("异常是：{}",e.toString());
        Result<String> result = new Result<>(500,"出异常了");
        result.setData(e.toString());
        return result;
    }
}
