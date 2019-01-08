package com.miaoshaproject.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: zhangsk
 * Date: 2019/1/4 17:35
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    //实现校验方法并返回校验结果

    public ValidationResult validate(Object object){
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(object);
        if(constraintViolationSet != null && constraintViolationSet.size()>0){
            //有错误
            result.setHashErrors(true);
            constraintViolationSet.forEach(constraintViolation ->{
                String errMsg = constraintViolation.getMessage();
                String propertyName = constraintViolation.getPropertyPath().toString();
                result.getErrorMsgMap().put(propertyName, errMsg);
            });
        }

        return result;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        //将hibernate validator通过工厂的初始化方式使其实例化
       this.validator =  Validation.buildDefaultValidatorFactory().getValidator();
    }
}