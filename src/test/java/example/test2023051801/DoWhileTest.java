package example.test2023051801;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/5/18 14:03
 * @Copyright: Copyright (c) 2019
 */
public class DoWhileTest {
    public static void main(String[] args) {
        long currentPage = 0L;
        long totalPages = 1L;
        do {
            currentPage++;
            totalPages = 10L;
            System.out.println(currentPage);
        } while (currentPage < totalPages);
    }
}
