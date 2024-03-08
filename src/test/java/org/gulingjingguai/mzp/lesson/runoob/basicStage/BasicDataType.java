package org.gulingjingguai.mzp.lesson.runoob.basicStage;

import org.junit.jupiter.api.Test;

public class BasicDataType {

    /**
     * 自动转换：byte,short,char->int->long->float->double
     */
    @Test
    public void basicDataTypeTest(){
        byte a = 1;// 8位
        System.out.println(a);
        short b = a;// 16位
        System.out.println(b);
        int c = a;// 32位
        System.out.println(c);
        long d = a;// 64位
        System.out.println(d);
        float f = 0.123f;// 32位单精度浮点数
        System.out.println(f);
        double dou = 0.123d;// 64位双精度浮点数
        System.out.println(dou);
        boolean bool = true;// 布尔类型
        System.out.println(bool);
        char ch = 'a';
        System.out.println(ch);// 16位Unicode字符,最小\u0000，最大\uffff

        char ch1 = 'A';// 65
        int chToInt1 = ch1;
        System.out.println(chToInt1);

        char ch2 = 'a';// 97
        int chToInt2 = ch2;
        System.out.println(chToInt2);
    }
}
