package com.wyc.order.utils;


import com.wyc.order.vo.ResultVO;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public class ResultVoUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
