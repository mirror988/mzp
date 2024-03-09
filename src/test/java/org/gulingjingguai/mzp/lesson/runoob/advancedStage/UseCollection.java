package org.gulingjingguai.mzp.lesson.runoob.advancedStage;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class UseCollection {

    @Test
    public void useHash(){
        HashMap hashMap = new HashMap();
        hashMap.put("key","value");
        System.out.println(hashMap);

        HashSet hashSet = new HashSet();
        hashSet.add("1");
        System.out.println(hashSet);
    }

    @Test
    public void useList(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        System.out.println(arrayList.toString());
        LinkedList linkedList = new LinkedList();
        linkedList.add("2");
        System.out.println(linkedList.toString());
    }

}
