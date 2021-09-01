package test.java.util.hashmap;

import test.java.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/3/9 20:49
 * @Copyright: Copyright (c) 2019
 */
public class HashMapTreeNodeTest {

    static final int DEFAULT_HASH = 1;
    static final String DEFAULT_SPACE = " ";
    static final String DEFAULT_TWO_SPACE = "  ";
    static final int DEFAULT_ROW = 2;

    public static void main(String[] args) {
        doTestTreeNode();
    }


    /**
     * 打印红黑树
     */
    public static void doTestTreeNode() {
        TreeNode<String, Integer>[] nodeArray = new TreeNode[1];
        TreeNode<String, Integer> node = new TreeNode(DEFAULT_HASH, "1", 1, null);
        nodeArray[0] = node;
        for (int i = 2; i < 17; i++) {
            node.putTreeVal(nodeArray, DEFAULT_HASH, i + "", i);
            // node.putTreeVal(nodeArray, i, i + "", i);
        }

        TreeNode<String, Integer> root = node.root();

        //打印红黑树
        //  printTree(root);
        System.out.println("=====================================================");
        System.out.println("=====================================================");
        printTreeByArray(root);
        TreeNode<String, Integer> node1 = root.find(DEFAULT_HASH, "9", String.class);

    }

    /**
     * 打印红黑树
     */
    public static void printTreeByArray(TreeNode root) {
        int maxLevel = findLevelByRoot(root, 1);
        // int length = (int) Math.pow(DEFAULT_ROW, maxLevel) - DEFAULT_ROW;
        // int length = (int) Math.pow(DEFAULT_ROW, maxLevel) ;
        int length = 1 << 8;
        // int row = length / (maxLevel - 1);
        int row = 2;

        TreeNode[][] arr = new TreeNode[length][length];

        //通过队列 实现 树的广度遍历
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        Map<Integer, Integer> levelCount = new HashMap<>();
        while (!queue.isEmpty()) {
            //检索并删除此双端队列代表的队列的头部。
            TreeNode node = queue.remove();

            //获取树的层级
            int level = findLevel(node, 1);
            Integer count = levelCount.get(level);
            if (count == null) {
                count = 0;
            }
            levelCount.put(level, ++count);
            if (node.parent == null) {
                arr[0][length / 2] = node;
            } else {
                int yIndex = 0;
                if (level * row - DEFAULT_ROW - 1 > length - 1) {
                    yIndex = length - 1;
                } else {
                    yIndex = level * row - DEFAULT_ROW - 1;
                }
                arr[yIndex][(count) * (length / ((int) Math.pow(DEFAULT_ROW, level - 1) + 1))] = node;
            }

            //添加左子节点到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            //添加右子节点到队列中
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        for (int i = 0; i < maxLevel * row - DEFAULT_ROW; i++) {
            TreeNode[] treeNodes = arr[i];


            for (int j = 0; j < treeNodes.length; j++) {
                if (treeNodes[j] == null) {
                    System.out.print(DEFAULT_SPACE);
                } else {
                    if (treeNodes[j].red) {
                        System.out.print("[" + treeNodes[j].value + "]");
                    } else {
                        System.out.print(treeNodes[j].value);
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * @param root
     */
    public static void printTree(TreeNode root) {
        List<String> printList = new ArrayList<>();
        //通过队列 实现 树的广度遍历
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        //临时父节点
        TreeNode tempRoot = null;
        //打印的 行
        String ln = "";
        //旧父节点的层级
        int tempParentLevel = 1;
        while (!queue.isEmpty()) {
            //检索并删除此双端队列代表的队列的头部。
            TreeNode node = queue.remove();
            //获取树的层级
            int level = findLevel(node, 1);

            //如果当前层级已经不是临时父节点的子节点
            //子节点层级 = 父节点 + 1
            if (level == (tempParentLevel + 2)) {
                rightList(printList, DEFAULT_TWO_SPACE);
                //把当前节点打印语句，都添加到打印集合中
                printList.add(ln);
                //重置 行
                ln = "";
                //临时父节点 下移动一层
                tempParentLevel++;
                tempRoot = node.parent;
            }

            //TODO 如果左兄弟节点为空，补层数个空格
            if (tempRoot != null && tempRoot.left != null && node.equals(tempRoot.right) && (tempRoot.left == null)) {
                ln = getSpace(level) + ln;
            }
            //红色节点
            if (node.red) {
                ln = ln + "[" + node.value + "]";
            } else {
                ln = ln + " " + node.value + " ";
            }
            ln = ln + getSpace(1);
            //首节点，添加到打印集合中
            if (tempRoot == null) {
                tempRoot = node;
                printList.add(ln);
                ln = "";
            }

            //添加左子节点到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            //添加右子节点到队列中
            if (node.right != null) {
                queue.add(node.right);

            }

            //如果队列为空，说明是最后一个子节点，点击到打印集合中
            if (queue.isEmpty()) {
                printList.add(getSpace(level) + ln);
                ln = "";
            }

        }

        printList.stream().forEach(System.out::println);
    }

    /**
     * 获取 N个 空格
     *
     * @param count
     * @return
     */
    public static String getSpace(int count) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <= count; i++) {
            stringBuffer.append(DEFAULT_TWO_SPACE);
        }
        return stringBuffer.toString();
    }

    public static int findLeft(TreeNode root, int level) {
        int count = 0;
        if (root != null) {
            for (int i = 0; i < level; i++) {

            }
        }
        return level;
    }

    /**
     * 获取树的层级
     *
     * @param treeNode 树节点
     * @param level    默认层级
     * @return
     */
    public static int findLevelByRoot(TreeNode treeNode, int level) {
        int leftLevel = level;
        int rightLevel = level;
        if (treeNode.left != null) {
            leftLevel = findLevelByRoot(treeNode.left, ++leftLevel);
        }
        if (treeNode.right != null) {
            rightLevel = findLevelByRoot(treeNode.right, ++rightLevel);
        }
        if (leftLevel > level) {
            level = leftLevel;
        }
        if (rightLevel > level) {
            level = rightLevel;
        }

        return level;
    }

    /**
     * 获取树的层级
     *
     * @param treeNode 树节点
     * @param level    默认层级
     * @return
     */
    public static int findLevel(TreeNode treeNode, int level) {
        if (treeNode.parent != null) {
            return findLevel(treeNode.parent, ++level);
        }
        return level;
    }

    /**
     * 打印树 右移
     *
     * @param list
     * @param str
     */
    public static void rightList(List<String> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, str + list.get(i));
        }
    }

}
