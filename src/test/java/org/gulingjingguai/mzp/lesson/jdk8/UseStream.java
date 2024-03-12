package org.gulingjingguai.mzp.lesson.jdk8;

import org.apache.commons.lang.ObjectUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseStream {
    @Test
    public void UseStream() {
        String[] a = new String[]{"1","2","3"};
        String[] b = new String[]{"3","4","5"};

        // 合并两个数组为一个Stream
        Stream<String> stream = Stream.concat(Arrays.stream(a), Arrays.stream(b));

        // 如果你需要合并后转换回数组，可以这样做
        Set<String> combinedArray = Arrays.stream(stream.toArray(String[]::new)).collect(Collectors.toSet());

        // 输出合并后的数组
        System.out.println(combinedArray.toString());  // 输出：[1, 2, 3, 3, 4, 5]
    }

    @Test
    public void UseFlatMap(){
        List<Map> a = new ArrayList<>();
        a.add(new HashMap(){{
            put("PRO_ID","1,2,3");
        }});
        a.add(new HashMap(){{
            put("PRO_ID","2,3,4");
        }});
        a.add(new HashMap(){{
            put("PRO_ID","3,4,5");
        }});
        a.add(new HashMap(){{
            put("PRO_ID","3,6,7");
        }});
        a.add(new HashMap(){{
            put("PRO_ID","4,8,9");
        }});
        a.add(new HashMap(){{
            put("PRO_ID","5,6,9");
        }});
        List<HashMap> collect = a.stream().flatMap(l -> Arrays.stream(ObjectUtils.toString(l.get("PRO_ID")).split(",")))
                .distinct().flatMap(l -> Stream.of(new HashMap() {{
                    put("PRO_ID", l);
                }}))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
