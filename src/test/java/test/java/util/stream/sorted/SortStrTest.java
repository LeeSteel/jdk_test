package test.java.util.stream.sorted;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/8/16 10:47
 * @Copyright: Copyright (c) 2019
 */
public class SortStrTest {

    @Test
    public void sortListMapTest() {
        List<Map<String, Object>> mapList = initListMap();
        System.out.println("before sorted : " + mapList);
        //正序， 时间最小且serial_no最小的最前面，空字段 放最后面
        List<Map> list = mapList.stream()
                .sorted(Comparator.comparing((Map<String, Object> t) ->
                        Integer.valueOf(t.get("init_date") + ""))
                        .thenComparing((Map<String, Object> t) -> Integer.valueOf(t.get("serial_no") + "")
                        ))
                .collect(Collectors.toList());

        System.out.println(" after sorted : " + list);
    }

    @Test
    public void sortStrBeanTest() {
        List<SortStrBean> sortStrBeanList = initData();

        //倒序， 时间最新的最前面，空字段 放最后面
        List<SortStrBean> collect = sortStrBeanList.stream().sorted(
                Comparator.comparing(SortStrBean::getField_one,
                        Comparator.nullsFirst(String::compareTo).reversed())
                        .thenComparing(t ->
                                        t.getField_two() != null ? Integer.parseInt(t.getField_two()
                                        ) : null,
                                Comparator.nullsFirst(Integer::compareTo).reversed())
        ).collect(Collectors.toList());

        System.out.println(collect);

    }

    /**
     * 初始化 数据
     *
     * @return
     */
    public List<Map<String, Object>> initListMap() {
        List<Map<String, Object>> testList = new ArrayList<>();
        Map<String, Object> map = new HashMap();
        map.put("init_date", 20210801);
        map.put("serial_no", 1);
        testList.add(map);

        map = new HashMap();
        map.put("init_date", 20210802);
        map.put("serial_no", 2);
        testList.add(map);

        map = new HashMap();
        map.put("init_date", 20210802);
        map.put("serial_no", 1);
        testList.add(map);

        map = new HashMap();
        map.put("init_date", 20210802);
        map.put("serial_no", 3);
        testList.add(map);

        map = new HashMap();
        map.put("init_date", 20210804);
        map.put("serial_no", 2);
        testList.add(map);

        return testList;
    }


    public List<SortStrBean> initData() {
        List<SortStrBean> sortStrBeanList = new ArrayList<>();
        SortStrBean sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210101");
        sortStrBean.setField_two("1");
        sortStrBeanList.add(sortStrBean);

        sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210201");
        sortStrBean.setField_two("10");
        sortStrBeanList.add(sortStrBean);

        sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210301");
        sortStrBean.setField_two("10");
        sortStrBeanList.add(sortStrBean);

        sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210401");
        sortStrBean.setField_two("1");
        sortStrBeanList.add(sortStrBean);


        sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210401");
        sortStrBean.setField_two("7");
        sortStrBeanList.add(sortStrBean);


        sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210401");
        sortStrBean.setField_two("17");
        sortStrBeanList.add(sortStrBean);


        sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210401");
        sortStrBean.setField_two("27");
        sortStrBeanList.add(sortStrBean);


        sortStrBean = new SortStrBean();
        sortStrBean.setField_one("20210401");
        sortStrBean.setField_two(null);
        sortStrBeanList.add(sortStrBean);


        sortStrBean = new SortStrBean();
        sortStrBean.setField_one(null);
        sortStrBean.setField_two(null);
        sortStrBeanList.add(sortStrBean);
        return sortStrBeanList;

    }

    /**
     * @version V1.0
     * @Title:
     * @Package
     * @Description:
     * @author: 李钢 2580704698@qq.com
     * @date: 2021/8/16 10:45
     * @Copyright: Copyright (c) 2019
     */

    @Data
    @ToString
    @EqualsAndHashCode
    public static class SortStrBean {
        public String field_one;
        public String field_two;
    }
}
