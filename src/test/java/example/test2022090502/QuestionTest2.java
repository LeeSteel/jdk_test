package example.test2022090502;



import java.util.stream.IntStream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/9/5 11:53
 * @Copyright: Copyright (c) 2019
 */
public class QuestionTest2 {
    static class Data {
        private static int counter = 0;

        public  void wrong() {
            counter++;
        }
    }

    public static void main(String[] args) {
        //  IntStream.rangeClosed(1,10000).parallel().forEach(i->new Data().wrong());
          IntStream.rangeClosed(1,10000).sequential().forEach(i->new Data().wrong());
        System.out.println(Data.counter);
    }
}
