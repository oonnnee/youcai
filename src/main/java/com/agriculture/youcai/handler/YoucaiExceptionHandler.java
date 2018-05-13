package com.agriculture.youcai.handler;

import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class YoucaiExceptionHandler {

    @ExceptionHandler(YoucaiException.class)
    @ResponseBody
    public ResultVO handleYoucaiException(YoucaiException e){
        return ResultVOUtils.error(e.getCode(), e.getMessage());
    }
}
