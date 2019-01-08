package com.miaoshaproject.response;

public class CommonReturnType {

    private String status;
    private Object data;

    public static CommonReturnType create(Object data){

        return create("success", data);
    }

    public static CommonReturnType create(String status, Object data){

        CommonReturnType returnType = new CommonReturnType();
        returnType.setStatus(status);
        returnType.setData(data);
        return returnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
