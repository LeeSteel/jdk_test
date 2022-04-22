package test.java.lang.functionalInterface;

import org.junit.jupiter.api.Test;
import test.java.lang.functionalInterface.funcation.DemoPrintFunction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/4/22 15:46
 * @Copyright: Copyright (c) 2019
 */
public class FunctionalInterfaceTests {
    @Test
    public void doDemoPrintTest() {
        List<Integer> list = Stream.of(1, 2, 3, 3).collect(Collectors.toList());

        DemoPrintFunction demoPrintFunction = item -> System.out.print(item);
        doDemoPrint(list,demoPrintFunction);
        System.out.println();

        doDemoPrint(list, item -> {
                    item++;
                    System.out.print(item);
                }
        );
    }

    public void doDemoPrint(List<Integer> list, DemoPrintFunction demoPrintFunction) {
        list.forEach(integer -> demoPrintFunction.demoPrintln(integer));
    }

}
