package cn.com.ssm.util;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface testAnnotation {
    String value() default "";
}
