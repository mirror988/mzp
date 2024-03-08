package org.gulingjingguai.mzp.lesson.runoob.advancedStage;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;


public class UseCollection {

    @Test
    public void useHashMap(){
        HashMap hashMap = new HashMap();
        hashMap.put("key","value");
        System.out.println(hashMap);

        HashSet hashSet = new HashSet();
        hashSet.add("1");
        System.out.println(hashSet);

    }

}
