package org.gulingjingguai.mzp.lesson.jdk8;

import org.apache.commons.lang.ObjectUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseStream {
    @Test
    public void UseStream() {
        String[] a = new String[]{"1", "2", "3"};
        String[] b = new String[]{"3", "4", "5"};

        // 合并两个数组为一个Stream
        Stream<String> stream = Stream.concat(Arrays.stream(a), Arrays.stream(b));

        // 如果你需要合并后转换回数组，可以这样做
        Set<String> combinedArray = Arrays.stream(stream.toArray(String[]::new)).collect(Collectors.toSet());

        // 输出合并后的数组
        System.out.println(combinedArray.toString());  // 输出：[1, 2, 3, 3, 4, 5]
    }

    @Test
    public void UseFlatMap() {
        List<Map> a = new ArrayList<>();
        a.add(new HashMap() {{
            put("PRO_ID", "1,2,3");
        }});
        a.add(new HashMap() {{
            put("PRO_ID", "2,3,4");
        }});
        a.add(new HashMap() {{
            put("PRO_ID", "3,4,5");
        }});
        a.add(new HashMap() {{
            put("PRO_ID", "3,6,7");
        }});
        a.add(new HashMap() {{
            put("PRO_ID", "4,8,9");
        }});
        a.add(new HashMap() {{
            put("PRO_ID", "5,6,9");
        }});
        List<HashMap> collect = a.stream().flatMap(l -> Arrays.stream(ObjectUtils.toString(l.get("PRO_ID")).split(",")))
                .distinct().flatMap(l -> Stream.of(new HashMap() {{
                    put("PRO_ID", l);
                }}))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void useGroupBy() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("CAL_DATE", "1");
        dataMap.put("PRO_ID", "2");
        dataMap.put("CAL_TYPE", "1");
        dataMap.put("DATE_FLAG", "1");
        dataMap.put("START_DATE", 20240315);
        dataMap.put("END_DATE", 20240315);
        dataMap.put("CAL_SOU", "1");
        list.add(dataMap);

        Map<String, Object> dataMap2 = new HashMap<>();
        dataMap2.put("CAL_DATE", "1");
        dataMap2.put("PRO_ID", "2");
        dataMap2.put("CAL_TYPE", "1");
        dataMap2.put("DATE_FLAG", "1");
        dataMap2.put("START_DATE", 20240314);
        dataMap2.put("END_DATE", 20240314);
        dataMap2.put("CAL_SOU", "1");
        list.add(dataMap2);

        Map<String, Object> dataMap3 = new HashMap<>();
        dataMap3.put("CAL_DATE", "1");
        dataMap3.put("PRO_ID", "1");
        dataMap3.put("CAL_TYPE", "1");
        dataMap3.put("DATE_FLAG", "1");
        dataMap3.put("START_DATE", 20240314);
        dataMap3.put("END_DATE", 20240314);
        dataMap3.put("CAL_SOU", "1");
        list.add(dataMap3);

        Comparator<Map<String,Object>> comparator = Comparator.<Map<String, Object>, String>comparing(map ->
                ObjectUtils.toString(map.get("PRO_ID")))
                .thenComparing(map -> ObjectUtils.toString(map.get("CAL_TYPE")),Comparator.reverseOrder())
                .thenComparing(map -> ObjectUtils.toString(map.get("START_DATE")))
                ;

        Collections.sort(list,comparator);

    }

}
