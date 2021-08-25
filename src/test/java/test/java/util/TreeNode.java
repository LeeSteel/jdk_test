package test.java.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/4/28 10:52
 * @Copyright: Copyright (c) 2019
 */
public class TreeNode<K, V> {
    /**
     * The bin count threshold for untreeifying a (split) bin during a
     * resize operation. Should be less than TREEIFY_THRESHOLD, and at
     * most 6 to mesh with shrinkage detection under removal.
     */
    static final int UNTREEIFY_THRESHOLD = 6;
    final int hash;
    final K key;
    V value;
    TreeNode<K, V> next;
    TreeNode<K, V> parent;  // red-black tree links
    TreeNode<K, V> left;
    TreeNode<K, V> right;
    TreeNode<K, V> prev;    // needed to unlink next upon deletion
    boolean red;

    TreeNode(int hash, K key, V val, TreeNode<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = val;
        this.next = next;
    }

    /**
     * Returns root of tree containing this node.
     */
    public final TreeNode<K, V> root() {
        for (TreeNode<K, V> r = this, p; ; ) {
            if ((p = r.parent) == null)
                return r;
            r = p;
        }
    }

    /**
     * Ensures that the given root is the first node of its bin.
     */
    public  static <K, V> void moveRootToFront(TreeNode<K, V>[] tab, TreeNode<K, V> root) {
        int n;
        if (root != null && tab != null && (n = tab.length) > 0) {
            int index = (n - 1) & root.hash;
            TreeNode<K, V> first = (TreeNode<K, V>) tab[index];
            if (root != first) {
                TreeNode<K, V> rn;
                tab[index] = root;
                TreeNode<K, V> rp = root.prev;
                if ((rn = root.next) != null)
                    ((TreeNode<K, V>) rn).prev = rp;
                if (rp != null)
                    rp.next = rn;
                if (first != null)
                    first.prev = root;
                root.next = first;
                root.prev = null;
            }
            assert checkInvariants(root);
        }
    }

    /**
     * Finds the node starting at root p with the given hash and key.
     * The kc argument caches comparableClassFor(key) upon first use
     * comparing keys.
     */
    public    final TreeNode<K, V> find(int h, Object k, Class<?> kc) {
        TreeNode<K, V> p = this;
        do {
            int ph, dir;
            K pk;
            TreeNode<K, V> pl = p.left, pr = p.right, q;
            if ((ph = p.hash) > h)
                p = pl;
            else if (ph < h)
                p = pr;
            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
                return p;
            else if (pl == null)
                p = pr;
            else if (pr == null)
                p = pl;
            else if ((kc != null ||
                    (kc = comparableClassFor(k)) != null) &&
                    (dir = compareComparables(kc, k, pk)) != 0)
                p = (dir < 0) ? pl : pr;
            else if ((q = pr.find(h, k, kc)) != null)
                return q;
            else
                p = pl;
        } while (p != null);
        return null;
    }

    /**
     * Calls find for root node.
     */
    public final TreeNode<K, V> getTreeNode(int h, Object k) {
        return ((parent != null) ? root() : this).find(h, k, null);
    }

    /**
     * Tie-breaking utility for ordering insertions when equal
     * hashCodes and non-comparable. We don't require a total
     * order, just a consistent insertion rule to maintain
     * equivalence across rebalancings. Tie-breaking further than
     * necessary simplifies testing a bit.
     */
    public  static int tieBreakOrder(Object a, Object b) {
        int d;
        if (a == null || b == null ||
                (d = a.getClass().getName().
                        compareTo(b.getClass().getName())) == 0)
            d = (System.identityHashCode(a) <= System.identityHashCode(b) ?
                    -1 : 1);
        return d;
    }

    /**
     * Forms tree of the nodes linked from this node. 从该节点链接的节点的表单树。
     *
     * @return root of tree
     */
    public final void treeify(TreeNode<K, V>[] tab) {
        TreeNode<K, V> root = null; // 定义树的根节点
        for (TreeNode<K, V> x = this, next; x != null; x = next) { // 遍历链表，x指向当前节点、next指向下一个节点
            next = (TreeNode<K, V>) x.next;  // 下一个节点
            x.left = x.right = null; // 设置当前节点的左右节点为空
            if (root == null) { // 如果还没有根节点
                x.parent = null; // 当前节点的父节点设为空
                x.red = false; // 当前节点的红色属性设为false（把当前节点设为黑色）
                root = x; // 根节点指向到当前节点
            } else { // 如果已经存在根节点了
                K k = x.key; // 取得当前链表节点的key
                int h = x.hash; // 取得当前链表节点的hash值
                Class<?> kc = null; // 定义key所属的Class
                for (TreeNode<K, V> p = root; ; ) { // 从根节点开始遍历，此遍历没有设置边界，只能从内部跳出
                    int dir, ph; // dir 标识方向（左右）、ph标识当前树节点的hash值
                    K pk = p.key; // 当前树节点的key
                    if ((ph = p.hash) > h) // 如果当前树节点hash值 大于 当前链表节点的hash值
                        dir = -1; // 标识当前链表节点会放到当前树节点的左侧
                    else if (ph < h)
                        dir = 1; // 右侧
                    else if ((kc == null && // 如果两个节点的key的hash值相等，那么还要通过其他方式再进行比较
                            (kc = comparableClassFor(k)) == null) || //如果当前链表节点的key实现了comparable接口，并且当前树节点和链表节点是相同Class的实例，那么通过comparable的方式再比较两者。
                            (dir = compareComparables(kc, k, pk)) == 0) // 如果还是相等，最后再通过tieBreakOrder比较一次
                        dir = tieBreakOrder(k, pk);

                    TreeNode<K, V> xp = p; // 保存当前树节点
                    if ((p = (dir <= 0) ? p.left : p.right) == null) { //如果dir 小于等于0 ： 当前链表节点一定放置在当前树节点的左侧，但不一定是该树节点的左孩子，也可能是左孩子的右孩子 或者 更深层次的节点。如果dir 大于0 ： 当前链表节点一定放置在当前树节点的右侧，但不一定是该树节点的右孩子，也可能是右孩子的左孩子 或者 更深层次的节点。 如果当前树节点不是叶子节点，那么最终会以当前树节点的左孩子或者右孩子 为 起始节点  再从GOTO1 处开始 重新寻找自己（当前链表节点）的位置 如果当前树节点就是叶子节点，那么根据dir的值，就可以把当前链表节点挂载到当前树节点的左或者右侧了。挂载之后，还需要重新把树进行平衡。平衡之后，就可以针对下一个链表节点进行处理了。
                        x.parent = xp; // 当前链表节点 作为 当前树节点的子节点
                        if (dir <= 0)
                            xp.left = x;  // 作为左孩子
                        else
                            xp.right = x; // 作为右孩子
                        root = balanceInsertion(root, x); // 重新平衡
                        break;
                    }
                }
            }
        }
        moveRootToFront(tab, root);
    }

    /**
     * Returns a list of non-TreeNodes replacing those linked from
     * this node.
     */
    public  final TreeNode<K, V> untreeify(HashMap<K, V> map) {
        TreeNode<K, V> hd = null, tl = null;
        for (TreeNode<K, V> q = this; q != null; q = q.next) {
            TreeNode<K, V> p =replacementNode(q, null);
            if (tl == null)
                hd = p;
            else
                tl.next = p;
            tl = p;
        }
        return hd;
    }
    // For conversion from TreeNodes to plain nodes
    public  TreeNode<K,V> replacementNode(TreeNode<K,V> p, TreeNode<K,V> next) {
        return new TreeNode<>(p.hash, p.key, p.value, next);
    }

    /**
     * Tree version of putVal.  putVal的树版本
     */
   public final TreeNode<K, V> putTreeVal(  TreeNode<K, V>[] tab,
                                    int h, K k, V v) {
        Class<?> kc = null;
        boolean searched = false;
        TreeNode<K, V> root = (parent != null) ? root() : this;
        for (TreeNode<K, V> p = root; ; ) {
            int dir, ph;
            K pk;
            if ((ph = p.hash) > h)
                dir = -1;
            else if (ph < h)
                dir = 1;
            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
                return p;
            else if ((kc == null &&
                    (kc = comparableClassFor(k)) == null) ||
                    (dir = compareComparables(kc, k, pk)) == 0) {
                if (!searched) {
                    TreeNode<K, V> q, ch;
                    searched = true;
                    if (((ch = p.left) != null &&
                            (q = ch.find(h, k, kc)) != null) ||
                            ((ch = p.right) != null &&
                                    (q = ch.find(h, k, kc)) != null))
                        return q;
                }
                dir = tieBreakOrder(k, pk);
            }

            TreeNode<K, V> xp = p;
            if ((p = (dir <= 0) ? p.left : p.right) == null) {
                TreeNode<K, V> xpn = xp.next;
                TreeNode<K, V> x = newTreeNode(h, k, v, xpn);
                if (dir <= 0)
                    xp.left = x;
                else
                    xp.right = x;
                xp.next = x;
                x.parent = x.prev = xp;
                if (xpn != null)
                    ((TreeNode<K, V>) xpn).prev = x;
                moveRootToFront(tab, balanceInsertion(root, x));
                return null;
            }
        }
    }

    // Create a tree bin node
    public   TreeNode<K,V> newTreeNode(int hash, K key, V value, TreeNode<K,V> next) {
        return new  TreeNode(hash, key, value, next);
    }
    /**
     * Returns k.compareTo(x) if x matches kc (k's screened comparable
     * class), else 0.
     */
    @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
    public  static int compareComparables(Class<?> kc, Object k, Object x) {
        return (x == null || x.getClass() != kc ? 0 :
                ((Comparable)k).compareTo(x));
    }
    /**
     * Removes the given node, that must be present before this call. 删除此调用之前必须存在的给定节点。
     * This is messier than typical red-black deletion code because we 这比典型的红黑删除代码更混乱，
     * cannot swap the contents of an interior node with a leaf 因为我们 不能交换内部节点的内容，
     * successor that is pinned by "next" pointers that are accessible 而叶子后继者是由遍历过程中可独立访问的“下一个”指针固定的。
     * independently during traversal. So instead we swap the tree 因此，我们交换树 链接。
     * linkages. If the current tree appears to have too few nodes, 如果当前树的节点似乎太少，
     * the bin is converted back to a plain bin. (The test triggers 则箱将转换回普通箱。 （测试会根据树结构触发. 2到6个节点之间的某个位置）。
     * somewhere between 2 and 6 nodes, depending on tree structure).
     */
    public   final void removeTreeNode(HashMap<K, V> map, TreeNode<K, V>[] tab,
                              boolean movable) {
        int n;
        if (tab == null || (n = tab.length) == 0)
            return;
        int index = (n - 1) & hash;
        TreeNode<K, V> first = (TreeNode<K, V>) tab[index], root = first, rl;
        TreeNode<K, V> succ = (TreeNode<K, V>) next, pred = prev;
        if (pred == null)
            tab[index] = first = succ;
        else
            pred.next = succ;
        if (succ != null)
            succ.prev = pred;
        if (first == null)
            return;
        if (root.parent != null)
            root = root.root();
        if (root == null || root.right == null ||
                (rl = root.left) == null || rl.left == null) {
            tab[index] = first.untreeify(map);  // too small  树的元素太少，转换为链表
            return;
        }
        TreeNode<K, V> p = this, pl = left, pr = right, replacement;
        if (pl != null && pr != null) {
            TreeNode<K, V> s = pr, sl;
            while ((sl = s.left) != null) // find successor
                s = sl;
            boolean c = s.red;
            s.red = p.red;
            p.red = c; // swap colors
            TreeNode<K, V> sr = s.right;
            TreeNode<K, V> pp = p.parent;
            if (s == pr) { // p was s's direct parent
                p.parent = s;
                s.right = p;
            } else {
                TreeNode<K, V> sp = s.parent;
                if ((p.parent = sp) != null) {
                    if (s == sp.left)
                        sp.left = p;
                    else
                        sp.right = p;
                }
                if ((s.right = pr) != null)
                    pr.parent = s;
            }
            p.left = null;
            if ((p.right = sr) != null)
                sr.parent = p;
            if ((s.left = pl) != null)
                pl.parent = s;
            if ((s.parent = pp) == null)
                root = s;
            else if (p == pp.left)
                pp.left = s;
            else
                pp.right = s;
            if (sr != null)
                replacement = sr;
            else
                replacement = p;
        } else if (pl != null)
            replacement = pl;
        else if (pr != null)
            replacement = pr;
        else
            replacement = p;
        if (replacement != p) {
            TreeNode<K, V> pp = replacement.parent = p.parent;
            if (pp == null)
                root = replacement;
            else if (p == pp.left)
                pp.left = replacement;
            else
                pp.right = replacement;
            p.left = p.right = p.parent = null;
        }

        TreeNode<K, V> r = p.red ? root : balanceDeletion(root, replacement);

        if (replacement == p) {  // detach
            TreeNode<K, V> pp = p.parent;
            p.parent = null;
            if (pp != null) {
                if (p == pp.left)
                    pp.left = null;
                else if (p == pp.right)
                    pp.right = null;
            }
        }
        if (movable)
            moveRootToFront(tab, r);
    }

    /**
     * Splits nodes in a tree bin into lower and upper tree bins, 将树箱中的节点拆分为上下树箱，如果现在太小，
     * or untreeifies if now too small. Called only from resize; 则或取消树化。仅从调整大小调用；
     * see above discussion about split bits and indices. 请参见上面有关拆分位和索引的讨论。
     *
     * @param map   the map
     * @param tab   the table for recording bin heads
     * @param index the index of the table being split
     * @param bit   the bit of hash to split on
     */
    public final void split(HashMap<K, V> map, TreeNode<K, V>[] tab, int index, int bit) {
        TreeNode<K, V> b = this;
        // Relink into lo and hi lists, preserving order
        TreeNode<K, V> loHead = null, loTail = null;
        TreeNode<K, V> hiHead = null, hiTail = null;
        int lc = 0, hc = 0;
        for (TreeNode<K, V> e = b, next; e != null; e = next) {
            next = (TreeNode<K, V>) e.next;
            e.next = null;
            if ((e.hash & bit) == 0) {
                if ((e.prev = loTail) == null)
                    loHead = e;
                else
                    loTail.next = e;
                loTail = e;
                ++lc;
            } else {
                if ((e.prev = hiTail) == null)
                    hiHead = e;
                else
                    hiTail.next = e;
                hiTail = e;
                ++hc;
            }
        }

        if (loHead != null) {
            if (lc <= UNTREEIFY_THRESHOLD)
                tab[index] = loHead.untreeify(map);
            else {
                tab[index] = loHead;
                if (hiHead != null) // (else is already treeified)
                    loHead.treeify(tab);
            }
        }
        if (hiHead != null) {
            if (hc <= UNTREEIFY_THRESHOLD)
                tab[index + bit] = hiHead.untreeify(map);
            else {
                tab[index + bit] = hiHead;
                if (loHead != null)
                    hiHead.treeify(tab);
            }
        }
    }

    /* ------------------------------------------------------------ */
    // Red-black tree methods, all adapted from CLR 红黑树 向左旋转 方法，全部改编自CLR

    public  static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> root,
                                            TreeNode<K, V> p) {
        TreeNode<K, V> r, pp, rl;
        if (p != null && (r = p.right) != null) {
            if ((rl = p.right = r.left) != null)
                rl.parent = p;
            if ((pp = r.parent = p.parent) == null)
                (root = r).red = false;
            else if (pp.left == p)
                pp.left = r;
            else
                pp.right = r;
            r.left = p;
            p.parent = r;
        }
        return root;
    }

    public  static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> root,
                                             TreeNode<K, V> p) {
        TreeNode<K, V> l, pp, lr;
        if (p != null && (l = p.left) != null) {
            if ((lr = p.left = l.right) != null)
                lr.parent = p;
            if ((pp = l.parent = p.parent) == null)
                (root = l).red = false;
            else if (pp.right == p)
                pp.right = l;
            else
                pp.left = l;
            l.right = p;
            p.parent = l;
        }
        return root;
    }

    public  static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> root,
                                                  TreeNode<K, V> x) {
        x.red = true;
        for (TreeNode<K, V> xp, xpp, xppl, xppr; ; ) {
            if ((xp = x.parent) == null) {
                x.red = false;
                return x;
            } else if (!xp.red || (xpp = xp.parent) == null)
                return root;
            if (xp == (xppl = xpp.left)) {
                if ((xppr = xpp.right) != null && xppr.red) {
                    xppr.red = false;
                    xp.red = false;
                    xpp.red = true;
                    x = xpp;
                } else {
                    if (x == xp.right) {
                        root = rotateLeft(root, x = xp);
                        xpp = (xp = x.parent) == null ? null : xp.parent;
                    }
                    if (xp != null) {
                        xp.red = false;
                        if (xpp != null) {
                            xpp.red = true;
                            root = rotateRight(root, xpp);
                        }
                    }
                }
            } else {
                if (xppl != null && xppl.red) {
                    xppl.red = false;
                    xp.red = false;
                    xpp.red = true;
                    x = xpp;
                } else {
                    if (x == xp.left) {
                        root = rotateRight(root, x = xp);
                        xpp = (xp = x.parent) == null ? null : xp.parent;
                    }
                    if (xp != null) {
                        xp.red = false;
                        if (xpp != null) {
                            xpp.red = true;
                            root = rotateLeft(root, xpp);
                        }
                    }
                }
            }
        }
    }

    public static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> root,
                                                 TreeNode<K, V> x) {
        for (TreeNode<K, V> xp, xpl, xpr; ; ) {
            if (x == null || x == root)
                return root;
            else if ((xp = x.parent) == null) {
                x.red = false;
                return x;
            } else if (x.red) {
                x.red = false;
                return root;
            } else if ((xpl = xp.left) == x) {
                if ((xpr = xp.right) != null && xpr.red) {
                    xpr.red = false;
                    xp.red = true;
                    root = rotateLeft(root, xp);
                    xpr = (xp = x.parent) == null ? null : xp.right;
                }
                if (xpr == null)
                    x = xp;
                else {
                    TreeNode<K, V> sl = xpr.left, sr = xpr.right;
                    if ((sr == null || !sr.red) &&
                            (sl == null || !sl.red)) {
                        xpr.red = true;
                        x = xp;
                    } else {
                        if (sr == null || !sr.red) {
                            if (sl != null)
                                sl.red = false;
                            xpr.red = true;
                            root = rotateRight(root, xpr);
                            xpr = (xp = x.parent) == null ?
                                    null : xp.right;
                        }
                        if (xpr != null) {
                            xpr.red = (xp == null) ? false : xp.red;
                            if ((sr = xpr.right) != null)
                                sr.red = false;
                        }
                        if (xp != null) {
                            xp.red = false;
                            root = rotateLeft(root, xp);
                        }
                        x = root;
                    }
                }
            } else { // symmetric
                if (xpl != null && xpl.red) {
                    xpl.red = false;
                    xp.red = true;
                    root = rotateRight(root, xp);
                    xpl = (xp = x.parent) == null ? null : xp.left;
                }
                if (xpl == null)
                    x = xp;
                else {
                    TreeNode<K, V> sl = xpl.left, sr = xpl.right;
                    if ((sl == null || !sl.red) &&
                            (sr == null || !sr.red)) {
                        xpl.red = true;
                        x = xp;
                    } else {
                        if (sl == null || !sl.red) {
                            if (sr != null)
                                sr.red = false;
                            xpl.red = true;
                            root = rotateLeft(root, xpl);
                            xpl = (xp = x.parent) == null ?
                                    null : xp.left;
                        }
                        if (xpl != null) {
                            xpl.red = (xp == null) ? false : xp.red;
                            if ((sl = xpl.left) != null)
                                sl.red = false;
                        }
                        if (xp != null) {
                            xp.red = false;
                            root = rotateRight(root, xp);
                        }
                        x = root;
                    }
                }
            }
        }
    }

    /**
     * Recursive invariant check
     */
    public  static <K, V> boolean checkInvariants(TreeNode<K, V> t) {
        TreeNode<K, V> tp = t.parent, tl = t.left, tr = t.right,
                tb = t.prev, tn = (TreeNode<K, V>) t.next;
        if (tb != null && tb.next != t)
            return false;
        if (tn != null && tn.prev != t)
            return false;
        if (tp != null && t != tp.left && t != tp.right)
            return false;
        if (tl != null && (tl.parent != t || tl.hash > t.hash))
            return false;
        if (tr != null && (tr.parent != t || tr.hash < t.hash))
            return false;
        if (t.red && tl != null && tl.red && tr != null && tr.red)
            return false;
        if (tl != null && !checkInvariants(tl))
            return false;
        if (tr != null && !checkInvariants(tr))
            return false;
        return true;
    }
    /**
     * Returns x's Class if it is of the form "class C implements
     * Comparable<C>", else null.
     */
    public static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType)t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
            }
        }
        return null;
    }

}
