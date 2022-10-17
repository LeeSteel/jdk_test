package example.test2022092301;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2022/9/23 10:13
 * @Copyright: Copyright (c) 2019
 */
public class TrieTest {
    Trie trie = new Trie();
    @BeforeEach
    public void initData () {
        trie.add("治疗结果");
        trie.add("治疗误解");
        trie.add("艾滋病血清学诊断");
        trie.add("诊断和治疗物质外渗");
        trie.add("艾滋病相关复合征");
    }

    @Test
    public void testSearch() {

        System.out.println(trie.contains("治疗结果"));
        System.out.println(trie.contains("诊断和治疗物质外渗"));

        System.out.println(trie.contains("诊断和治疗物质外"));
        System.out.println(trie.contains("治疗结"));
        System.out.println(trie.contains("治疗"));
        System.out.println(trie.contains("治结"));
        System.out.println(trie.contains("艾滋病"));
        System.out.println(trie.contains("艾滋 病"));
        System.out.println(trie.contains(" "));
        System.out.println(trie.contains(" 艾滋"));
        System.out.println(trie.contains(""));
    }
}
