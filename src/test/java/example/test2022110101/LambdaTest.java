package example.test2022110101;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/11/1 15:55
 * @Copyright: Copyright (c) 2019
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People(1, "Hikari"));
        list.add(new People(2, "Alice"));
        executor(list, "Alice",
                (people, name) -> name != null && name.equals(people.getName()),
                o -> System.out.println(o));

        /*
        executor(list, "Alice", new BiFunction<People, String, Boolean>() {
            @Override
            public Boolean apply(People people, String name) {
                return name!=null && name.equals(people.getName());
            }
        }, new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
         */
    }

    public static void executor(List<People> peopleList, String name,
                                BiFunction<People, String, Boolean> biFunction, Consumer<Object> consumer) {
        peopleList.forEach(p -> {
            if (biFunction.apply(p, name)) {
                consumer.accept(p);
            }
        });
    }
}

class People {
    private Integer id;
    private String name;

    public People() {
    }

    public People(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
