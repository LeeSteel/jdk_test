package test.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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


