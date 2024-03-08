package org.gulingjingguai.mzp.lesson.runoob.basicStage;

import org.junit.jupiter.api.Test;

public class BitWiseOperation {
    @Test
    public void bitWiseOper(){
        System.out.println(1&1);
        System.out.println(1|1);
        System.out.println(1^1);
        System.out.println(~1);
        System.out.println(1<<2);
        System.out.println(4>>2);
        //按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。
        System.out.println(4>>>2);
    }
}
