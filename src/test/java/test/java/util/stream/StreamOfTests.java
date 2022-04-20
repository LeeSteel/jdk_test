package test.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/4/20 15:22
 * @Copyright: Copyright (c) 2019
 */
public class StreamOfTests {

    @Test
    public void ofArrayTest() {
        Stream<String> stream = Stream.of("a", "b", "c");
        System.out.println(stream.collect(Collectors.toList()));
    }
    @Test
    public void ofListTest() {
        List<String>  tempStream = Stream.of("a", "b", "c").collect(Collectors.toList());
        //一个list 会被当成一个对象
        Stream<List<String>> stream = Stream.of(tempStream,tempStream);
        //最终结果成了 二维数据
        System.out.println(stream.collect(Collectors.toList()));
    }

    @Test
    public void ofObjectTest() {
        Stream<Object> stream = Stream.of(Integer.valueOf(1)
                , Double.valueOf(2.0)
                , Long.valueOf(3L)
        );
        System.out.println(stream.collect(Collectors.toList()));
    }
}
