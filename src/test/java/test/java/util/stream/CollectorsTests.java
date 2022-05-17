package test.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
     * Collectors#toCollection 方法,配合 Stream 流使用,获得一个想要的 Collection
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

    /**
     * Collectors#toList 方法,配合Stream 流使用,获得一个 ArrayList
     */
    @Test
    public void toListTest() {
        //想获得一个 ArrayList
        List<String> toListList = Stream.of("A,B,C", "D,E,F", "G,H,I")
                .collect(Collectors.toList());
        System.out.println(toListList.toString());
        System.out.println(toListList.getClass());

        //想获得一个 ArrayList
        List<String> arrayList = Stream.of("A,B,C", "D,E,F", "G,H,I")
                .collect(Collectors.toCollection((Supplier<List<String>>) ArrayList::new));
        System.out.println(arrayList.toString());
        System.out.println(arrayList.getClass());

        //内部使用 AbstractList#equals 重写的equals 对比list里面的每个元素是否相等
        System.out.println(Objects.equals(toListList,arrayList));
    }


    /**
     * Collectors#toSet 方法,配合Stream 流使用,获得一个 HashSet
     */
    @Test
    public void toSetTest() {
        //想获得一个 HashSet
        Set<String> toSetSet = Stream.of("A,B,C", "D,E,F", "G,H,I")
                .collect(Collectors.toSet());
        System.out.println(toSetSet.toString());
        System.out.println(toSetSet.getClass());

        //想获得一个 HashSet
        Set<String> hashSet = Stream.of("A,B,C", "D,E,F", "G,H,I")
                .collect(Collectors.toCollection((Supplier<Set<String>>) HashSet::new));
        System.out.println(hashSet.toString());
        System.out.println(hashSet.getClass());

        //内部使用 AbstractSet#equals 重写的equals 对比 Set 里面的每个元素是否相等
        System.out.println(Objects.equals(toSetSet,hashSet));
    }
}
