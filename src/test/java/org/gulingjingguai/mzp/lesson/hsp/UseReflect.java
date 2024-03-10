package org.gulingjingguai.mzp.lesson.hsp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UseReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //通过Class.forName()方法获取Class对象
        Class<?> aClass = Class.forName("org.gulingjingguai.mzp.lesson.hsp.ReflectFile");
        System.out.println(aClass);

        //通过类名.class获取Class对象
        Class<ReflectFile> reflectFileClass = ReflectFile.class;
        System.out.println(reflectFileClass);

        //通过成员.getClass()方法获取Class对象
        ReflectFile reflectFile = new ReflectFile();
        Class<? extends ReflectFile> aClass1 = reflectFile.getClass();
        System.out.println(aClass1);

        Constructor<?> constructor = aClass.getConstructor();
        ReflectFile reflectFile1 = (ReflectFile) constructor.newInstance();
        reflectFile1.cry();
        reflectFile1.smile();

        Method declaredMethod = aClass.getDeclaredMethod("cry");
        declaredMethod.invoke(reflectFile1);

        Field name = aClass.getDeclaredField("NAME");
        System.out.println(name);

    }
}
