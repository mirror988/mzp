package org.gulingjingguai.mzp.lesson.hsp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 定义自定义注解
@Target(ElementType.METHOD)  // 指定注解可以应用的目标元素类型，这里指定为方法
@Retention(RetentionPolicy.RUNTIME)  // 指定注解在运行时保留
public @interface MyAnnotation {
    // 定义注解的元素
    String value() default "Default Value";  // 定义一个名为"value"的元素，可以在使用注解时指定值，默认值为"Default Value"
    int number() default 42;  // 定义一个名为"number"的元素，可以在使用注解时指定整数值，默认值为42
    boolean flag() default true;  // 定义一个名为"flag"的元素，可以在使用注解时指定布尔值，默认值为true
}
