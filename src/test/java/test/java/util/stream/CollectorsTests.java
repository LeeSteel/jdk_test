package test.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/5/17 17:30
 * @Copyright: Copyright (c) 2019
 */
public class CollectorsTests {
    /**
     * Collectors#toCollection 方法,配合Stream 流使用,获得一个想要的Collection
     */
    @Test
    public void toCollectionTest() {
        //想获得一个 ArrayList
        List<String> arrayList = Stream.of("A,B,C", "D,E,F", "G,H,I")
                .collect(Collectors.toCollection((Supplier<List<String>>) ArrayList::new));
        System.out.println(arrayList.toString());
        System.out.println(arrayList.getClass());

        //想获得一个 CopyOnWriteArrayList
        List<String> copyOnWriteArrayList = Stream.of("A,B,C", "D,E,F", "G,H,I")
                .collect(Collectors.toCollection((Supplier<List<String>>) CopyOnWriteArrayList::new));
        System.out.println(copyOnWriteArrayList.toString());
        System.out.println(copyOnWriteArrayList.getClass());
    }
}
