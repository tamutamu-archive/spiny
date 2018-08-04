package com.gioov.spiny.common.annotation.loggingoperation;

/**
 * @author godcheese
 * @date 2018-08-03
 */
public enum OperationTypeEnum {


    /**
     * 普通操作
     */
    NORMAL(0),

    /**
     * 登录操作
     */
    LOGIN(1),


    ;

    private Integer value;

    OperationTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

}
