package com.gioov.spiny.common.annotation.loggingoperation;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author godcheese
 * @date 2018-08-03
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggingOperation {

    /**
     * 操作内容
     * @return
     */
    String value() default "";

    /**
     * 操作内容
     * @return
     */
    @AliasFor("value")
    String operation() default "";

    /**
     * 操作类型
     * @return
     */
    OperationTypeEnum operationType() default OperationTypeEnum.NORMAL;

}
