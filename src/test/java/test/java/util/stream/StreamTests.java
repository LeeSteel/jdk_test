package test.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/4/20 15:46
 * @Copyright: Copyright (c) 2019
 */
public class StreamTests {

    @Test
    public void ofArrayTest() {

        Stream<String> stream = Stream.of("a", "b", "c");
        System.out.println(stream.collect(Collectors.toList()));

        // Stream.of 生成的流 使用一次后就会被关闭
        //System.out.println(stream.collect(Collectors.toList()));
    }

    @Test
    public void reduceTest() {
        List<Integer> list = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        System.out.println(list.stream().reduce(0, Integer::sum));

        System.out.println(list.stream().reduce(0, (a, b) -> a + b));
    }

    @Test
    public void distinctTest() {
        List<Integer> list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        List<StreamBean> beanList = getStreamBeanList();
        /**
         * 去重, 根据 equals
         */
        System.out.println(beanList.stream().distinct().collect(Collectors.toList()));
    }

    @Test
    public void peekTest(){
        //此方法的存在主要是为了支持调试，您希望在元素流过管道中的某个点时查看它们
        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void limitTest(){
        int limitMaxSize = 2;
        List<Integer> list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        System.out.println(list.stream().limit(limitMaxSize).collect(Collectors.toList()));

        //测试 limit 大于 集合的情况
        limitMaxSize = 6;
        list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        System.out.println(list.stream().limit(limitMaxSize).collect(Collectors.toList()));

         // limit 不能小于 0
        limitMaxSize = 0;
        list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        System.out.println(list.stream().limit(limitMaxSize).collect(Collectors.toList()));

    }

    @Test
    public void skipTest() {
        int skipSize = 2;
        List<Integer> list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        System.out.println(list.stream().skip(skipSize).collect(Collectors.toList()));
        System.out.println(list.parallelStream().skip(skipSize).collect(Collectors.toList()));

        // skipSize 可以比 流元素数量大,此时返回 空流
        skipSize = 6;
        list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        System.out.println(list.stream().skip(skipSize).collect(Collectors.toList()));
        System.out.println(list.parallelStream().skip(skipSize).collect(Collectors.toList()));

        //
        skipSize = 0;
        list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        System.out.println(list.stream().skip(skipSize).collect(Collectors.toList()));
        System.out.println(list.parallelStream().skip(skipSize).collect(Collectors.toList()));

        // skipSize 不能小于0
    }


    @Test
    public void forEachTest() {
        List<Integer> list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());
        list.stream().forEach(System.out::print);
        System.out.println();
        list.parallelStream().forEach(System.out::print);
    }

    @Test
    public void forEachOrderedTest() {
        List<Integer> list = Stream.of(4, 5, 1, 6, 2, 3).collect(Collectors.toList());
        //forEachOrdered 对于普通流 和 forEach 无区别
        list.stream().forEachOrdered(System.out::print);
        System.out.println();
        //forEachOrdered 在并行流处理的时候，保证元素的顺序
        list.parallelStream().forEachOrdered(System.out::print);
    }

    @Test
    public void anyMatchTest() {
        List<Integer> list = Stream.of(-1, -2, 4, 5, 1, 6, 2, 3).collect(Collectors.toList());
        //条件函数
        Predicate<Integer> predicate = t -> t > 0;
        // anyMatch 流里面任意一个元素 满足条件
        if (list.stream().anyMatch(predicate)) {
            //打印满足条件的元素
            System.out.println(list.stream().filter(predicate).collect(Collectors.toList()));
        }
    }


    @Test
    public void allMatchTest() {
        List<Integer> list = Stream.of(-1, -2, 4, 5, 1, 6, 2, 3).collect(Collectors.toList());
        //条件函数
        Predicate<Integer> predicate = t -> t > 0;
        // allMatch 流里面 所有元素 满足条件
        if (list.stream().allMatch(predicate)) {
            //打印满足条件的元素
            System.out.println(list.stream().filter(predicate).collect(Collectors.toList()));
        }
    }
    @Test
    public void noneMatchTest() {
        List<Integer> list = Stream.of(-1, -2, 4, 5, 1, 6, 2, 3).collect(Collectors.toList());
        //条件函数
        Predicate<Integer> predicate = t -> t > 0;
        Predicate<Integer> contraryPredicate = t -> t < 0;
        // noneMatch 流里面 所有元素都 不满足条件
        if (list.stream().noneMatch(predicate)) {
            //打印 不满足条件的元素
            System.out.println(list.stream().filter(contraryPredicate).collect(Collectors.toList()));
        }

        list = Stream.of(-1, -2, -3).collect(Collectors.toList());
         // noneMatch 流里面 所有元素都 不满足条件
        if (list.stream().noneMatch(predicate)) {
            //打印 不满足条件的元素
            System.out.println(list.stream().filter(contraryPredicate).collect(Collectors.toList()));
        }
    }

    /**
     *  findFirst 会找 流里面的 第一个元素
     *  并行流 parallelStream 和 同步流 stream 结果一致
     */
    @Test
    public void findFirstTest() {
        List<Integer> list = Stream.of(-1, -2, 4, 5, 1, 6, 2, 3).collect(Collectors.toList());
        //找到第一个元素
        list.stream().findFirst()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();
        //找到第一个元素
        list.parallelStream().findFirst()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();

        //数据量 太少不会触发扩容,不会重新计算 hash ,可能出现 伪有序
        Set<Integer> set = Stream.of(19, 0, -3, -1, -2, 4, 5, 1, 6, 2, 3, 18, 7, 9, 8, 10, 13, 12, 14, 16)
                .collect(Collectors.toSet());

        //找到第一个元素
        set.stream().findFirst()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();
        //找到第一个元素
        set.parallelStream().findFirst()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();
        System.out.println(set.toString());

    }

    /**
     *  findAny 会找 流里面的 任意一个元素
     *  同步流 stream 中  等同于  findFirst
     *  并行流 parallelStream 中 则不保证 获取顺序
     */
    @Test
    public void findAnyTest() {
        List<Integer> list = Stream.of(-1, -2, 4, 5, 1, 6, 2, 3).collect(Collectors.toList());
        //找到第一个元素
        list.stream().findAny()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();
        //找到第一个元素
        list.parallelStream().findAny()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();
        //数据量 太少不会触发扩容,不会重新计算 hash ,可能出现 伪有序
        Set<Integer> set = Stream.of(19, 0, -3, -1, -2, 4, 5, 1, 6, 2, 3, 18, 7, 9, 8, 10, 13, 12, 14, 16)
                .collect(Collectors.toSet());

        //找到第一个元素
        set.stream().findAny()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();
        //找到第一个元素
        set.parallelStream().findAny()
                //如果存在值，就打印出来
                .ifPresent(System.out::print);
        System.out.println();
        System.out.println(set.toString());

    }

    private List<StreamBean> getStreamBeanList(){
        List<StreamBean> beanList =new ArrayList<>();
        StreamBean  streamBean = new StreamBean();
        streamBean.setId(1);
        streamBean.setName("bean1");

        beanList.add(streamBean);

        streamBean = new StreamBean();
        streamBean.setId(1);
        streamBean.setName("bean1");
        beanList.add(streamBean);


        streamBean = new StreamBean();
        streamBean.setId(2);
        streamBean.setName("bean2");
        beanList.add(streamBean);

        streamBean = new StreamBean();
        streamBean.setId(3);
        streamBean.setName("bean3");
        beanList.add(streamBean);

        return  beanList;
    }
}


