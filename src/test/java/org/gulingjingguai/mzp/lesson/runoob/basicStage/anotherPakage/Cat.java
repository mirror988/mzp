package org.gulingjingguai.mzp.lesson.runoob.basicStage.anotherPakage;

import org.gulingjingguai.mzp.lesson.runoob.basicStage.onePackage.Animal;

public class Cat extends Animal{
    @Override
    protected void cry() {
        super.cry();
    }

    public static void main(String[] args) {
        //protected 方法，不同包的子类，不能访问到
        Animal animal = new Animal();
        //但是可以访问继承父类的protected方法
        Cat cat = new Cat();
        cat.cry();
    }
}
