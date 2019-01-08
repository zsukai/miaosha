package com.miaoshaproject.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @Author: zhangsk
 * Date: 2019/1/4 17:28
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ValidationResult {
    //校验结果是否有错
    private boolean hashErrors = false;

    //存放错误信息
    private Map<String, String> errorMsgMap = new HashMap<>();

    public boolean isHashErrors() {
        return hashErrors;
    }

    public void setHashErrors(boolean hashErrors) {
        this.hashErrors = hashErrors;
    }

    public Map<String, String> getErrorMsgMap() {
        return errorMsgMap;
    }

    public void setErrorMsgMap(Map<String, String> errorMsgMap) {
        this.errorMsgMap = errorMsgMap;
    }

    //实现通用的通过格式化字符串信息获取错误结果的msg方法
    public String getErrMsg(){

       return StringUtils.join(errorMsgMap.values().toArray(), ",");
    }
}