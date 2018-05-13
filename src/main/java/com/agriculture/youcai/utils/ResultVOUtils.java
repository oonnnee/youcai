package com.agriculture.youcai.utils;

import com.agriculture.youcai.vo.ResultVO;

public class ResultVOUtils {

    public static ResultVO success(Object data){
        return new ResultVO(0,"成功", data);
    }

    public static ResultVO success(){
        return new ResultVO(0, "成功", null);
    }

    public static ResultVO error(Integer code, String msg){
        return new ResultVO(code, msg, null);
    }

}
