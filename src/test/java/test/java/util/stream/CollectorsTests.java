package test.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import java.util.jar.Attributes;
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


    @Test
    public void joiningTest(){
        //获得一个 HashSet
        Set<String> toSetSet = Stream.of("A","B","C", "D","E","F", "G","H","I")
                .collect(Collectors.toSet());
        //Collectors#joining 按元素顺序拼接,使用 StringBuilder实现,线程不安全
        System.out.println(toSetSet.stream().collect(Collectors.joining()));

        //Collectors#joining 按元素顺序拼接,使用 StringJoiner#StringBuilder实现,线程不安全
        System.out.println(toSetSet.stream().collect(Collectors.joining(",")));

        //Collectors#joining 按元素顺序拼接,使用 StringJoiner#StringBuilder实现,线程不安全
        System.out.println(toSetSet.stream().collect(Collectors.joining(",","prefix","suffix")));
    }


    @Test
    public void mappingTest(){
        List<StreamBean> beanList = getStreamBeanList();
        // demo 1
        // 获取集合里元素的名字 放至一个集合
        List<String> nameList = beanList.stream()
                .collect(Collectors.mapping(StreamBean::getName, Collectors.toList()));
        System.out.println(nameList);

        // 获取集合里元素的名字 放至一个集合
        nameList = beanList.stream()
                .map(StreamBean::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);

        // demo 2
        // 根据名字分组,把同名的人ID放到一个集合
        Map<String, List<Integer>> groupMap
                = beanList.stream()
                .collect(Collectors.groupingBy(StreamBean::getName,
                        Collectors.mapping(StreamBean::getId, Collectors.toList())));
        System.out.println(groupMap);

        //根据名字分组,把同名的人 bean对象 放到一个集合
        Map<String, List<StreamBean>> groupBeanMap = beanList.stream()
                .collect(Collectors.groupingBy(StreamBean::getName,
                        HashMap::new, Collectors.toList()));
        System.out.println(groupBeanMap);

    }

    private List<StreamBean> getStreamBeanList(){
        List<StreamBean> beanList =new ArrayList<>();
        StreamBean  streamBean = new StreamBean();
        streamBean.setId(1);
        streamBean.setName("Json");

        beanList.add(streamBean);

        streamBean = new StreamBean();
        streamBean.setId(2);
        streamBean.setName("Json");
        beanList.add(streamBean);


        streamBean = new StreamBean();
        streamBean.setId(3);
        streamBean.setName("Gust");
        beanList.add(streamBean);

        streamBean = new StreamBean();
        streamBean.setId(4);
        streamBean.setName("Pony");
        beanList.add(streamBean);

        return  beanList;
    }
}
