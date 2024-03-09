package org.gulingjingguai.mzp.lesson.hsp;

import java.lang.reflect.Method;

public class UseAnnotation {

    // 使用自定义注解，指定元素值
    @MyAnnotation(value = "Hello", number = 123, flag = false)
    public void myMethod() {
        // 方法体
    }

    public static void main(String[] args) {
        // 获取MyClass类中的所有方法
        Method[] methods = UseAnnotation.class.getDeclaredMethods();

        // 遍历方法，查找带有MyCustomAnnotation注解的方法
        for (Method method : methods) {
            // 判断方法上是否有MyCustomAnnotation注解
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                // 获取注解实例
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

                // 获取注解元素值
                String value = annotation.value();
                int number = annotation.number();
                boolean flag = annotation.flag();

                // 打印注解元素值
                System.out.println("Method: " + method.getName());
                System.out.println("value: " + value);
                System.out.println("number: " + number);
                System.out.println("flag: " + flag);
                System.out.println();
            }
        }
    }
}
