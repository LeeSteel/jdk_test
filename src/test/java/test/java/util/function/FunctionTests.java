package test.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:  Function 测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/1 18:43
 * @Copyright: Copyright (c) 2019
 */
public class FunctionTests {
    @Test
    public void applyToUpperCaseTest(){
        Function<String, String> toUpperCaseFunction = str -> str.toUpperCase();
        String result = toUpperCaseFunction.apply("www.baidu.com");
        System.out.println(result);
    }

    @Test
    public void applyStrLengthTest(){
        Function<String, Integer> strLengthFunction = str -> str.length();
        int length = strLengthFunction.apply("www.baidu.com");
        System.out.println(length);
    }

    @Test
    public void andThenSimpleTest(){
        Function<String, Integer> strLengthFunction = str -> str.length();
        Function<Integer,Integer> doubleFunction = length -> length << 1;

        Integer doubleLength =  strLengthFunction.andThen(doubleFunction).apply("www.baidu.com");
        System.out.println(doubleLength);

        // 自增函数
        Function<Integer,Integer> addFunction = length -> ++ length;

        // andThen 可以多个 Function 函数连接使用， 顺序执行，这里先  length*2 后  +1 ,即 addLength = length*2 + 1
        Integer addLength = strLengthFunction.andThen(doubleFunction).andThen(addFunction).apply("www.baidu.com");
        System.out.println(addLength);

        // 这里先  length+1 后 *2 ,即 addLength = (length+1)*2
          addLength = strLengthFunction.andThen(addFunction).andThen(doubleFunction).apply("www.baidu.com");
        System.out.println(addLength);
     }

    /**
     * 把 list 中的数据，按指定策略(function)处理成 Map后返回
     */
     @Test
     public void functionParamForLengthTest(){
         List<String> list = Arrays.asList("java", "nodejs", "www.baidu.com");
         //1、 lambda 方式
         Function<String, Integer> lengthFunction = str -> str.length();
         Map<String, Integer> listToMap = listToMapProcessing(list, lengthFunction);
         System.out.println(listToMap);

         //2、 方法引用方式
         Map<String, Integer> listToMap2 = listToMapProcessing(list, String::length);
         System.out.println(listToMap2);

         //3、 实际写法 1、2有点炫技
         Map<String, Integer> listToMap3 = list.stream().collect(Collectors.toMap(t->t,String::length));
         System.out.println(listToMap3);
     }

    /**
     *   把 list 中的数据，按指定策略(function)处理成 Map后返回
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    private <T, R> Map<T, R> listToMapProcessing(List<T> list, Function<T, R> function) {
        HashMap<T, R> hashMap = new HashMap<>();
        for (T t : list) {
            hashMap.put(t, function.apply(t));
        }
        return hashMap;
    }

    /**
     * 测试使用 function作为参数，处理list数据
     */
    @Test
    public void functionMethodParametersForListDataTest( ) {
        List<String> list = Arrays.asList("Java", "Nodejs", "www.baidu.com");
        //1、 方法引用方式
        List<String> upperList = listProcessing(list, String::toUpperCase);
        List<String> lowerList = listProcessing(list, String::toLowerCase);
        System.out.println(upperList);
        System.out.println(lowerList);

        //2、 Lambda 方式
        List<String> upperList2 = listProcessing(list, x -> x.toUpperCase());
        List<String> lowerList2 = listProcessing(list, x -> x.toLowerCase());
        System.out.println(upperList2);
        System.out.println(lowerList2);

        //3、 stream 写法
        List<String> upperList3 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> lowerList3 = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(upperList3);
        System.out.println(lowerList3);

    }

    /**
     *  把 list 中的数据，按指定策略(function)处理后返回
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    private <T, R> List<R> listProcessing(List<T> list, Function<T, R> function) {
        List<R> resultList = new ArrayList<>(list.size());
        for (T t : list) {
            resultList.add(function.apply(t));
        }
        return resultList;
    }

}
