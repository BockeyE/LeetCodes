package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bockey
 */
public class DFS {

//    杨辉三角 递归
    public static int func(int left, int right) {
        if (right == 1) {
            return 1;
        }
        if (right == left + 1) {
            return 1;
        }
        return func(left - 1, right - 1) + func(left - 1, right);
    }

    static void dfs(int[][] map, int left, int right) {
        int n = map.length;

        if (left < 0 || right < 0 || left >= n || right >= n || map[left][right] == 0) {
            return;
        }
        map[left][right] = 0;
        dfs(map, left - 1, right);
        dfs(map, left + 1, right);
        dfs(map, left, right - 1);
        dfs(map, left, right + 1);
    }

    public static int numGroups(int[][] map) {
        if (map == null || map.length == 0) {
            return 0;
        }
        int n = map.length;
        int count = 0;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (map[r][c] == 1) {
                    ++count;
                    dfs(map, r, c);
                }
            }
        }
        return count;
    }

    static int dfsCount(int[][] map, int left, int right, int[] ret) {
        int n = map.length;
        if (left < 0 || right < 0 || left >= n || right >= n || map[left][right] == 0) {
            return 0;
        }
        map[left][right] = 0;
        ret[0] += dfsCount(map, left - 1, right, ret);
        ret[0] += dfsCount(map, left + 1, right, ret);
        ret[0] += dfsCount(map, left, right - 1, ret);
        ret[0] += dfsCount(map, left, right + 1, ret);
        ret[0] += 1;
        return ret[0];
    }

    static void dfs(int[][] map, int left, int right, List<List<Integer>> temp) {
        int n = map.length;
        if (left < 0 || right < 0 || left >= n || right >= n || map[left][right] == 0) {
            return;
        }
        List<Integer> r = new ArrayList<>(2);
        r.add(left);
        r.add(right);
        temp.add(r);
        map[left][right] = 0;
        dfs(map, left - 1, right, temp);
        dfs(map, left + 1, right, temp);
        dfs(map, left, right - 1, temp);
        dfs(map, left, right + 1, temp);

    }

    public static int numGroups2(int[][] map) {
        if (map == null || map.length == 0) {
            return 0;
        }
        int n = map.length;
        int count = 0;
        List<List<List<Integer>>> rets = new ArrayList<>();
        for (int left = 0; left < n; ++left) {
            for (int right = 0; right < n; ++right) {
                if (map[left][right] == 1) {
                    ++count;
                    List<List<Integer>> temp = new ArrayList<>();
                    dfs(map, left, right, temp);
                    if (temp.size() > 0) {
                        rets.add(temp);
                    }
                }
            }
        }
        for (List<List<Integer>> ret : rets) {
            if(ret.size()<2) continue;
            System.out.println(ret);
        }
        return count;
    }

    public static void main(String[] args) {

        int[] ret = {0};

        int[] l1 = {0, 0, 0, 1, 1};
        int[] l2 = {0, 0, 0, 0, 1};
        int[] l3 = {1, 0, 1, 1, 0};
        int[] l4 = {0, 0, 1, 1, 0};
        int[] l5 = {0, 1, 0, 0, 0};
        int[][] map = {l1, l2, l3, l4, l5};
        System.out.println(numGroups2(map));
//        System.out.println(dfsCount(map, 0, 3, ret));
//        System.out.println(func(5, 4));
    }

    class LRUCache {
        private class Node {
            private int key;
            private int value;
            private Node pre;
            private Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node head = new Node();
        private Node tail = new Node();
        private int maxSize;
        private int size;
        private HashMap<Integer, Node> hashMap = new HashMap<>();

        private void add(Node node) {
            Node originHead = head.next;
            head.next = node;
            node.pre = head;
            node.next = originHead;
            originHead.pre = node;
        }

        private void del(Node node) {
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            node.pre = null;
            node.next = null;
        }

        public LRUCache(int maxSize) {
            head.next = tail;
            tail.pre = head;
            this.maxSize = maxSize;
            size = 0;
        }

        public int get(int key) {
            Node node = hashMap.get(key);
            if (null == node) {
                return -1;
            }
            del(node);
            add(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = hashMap.get(key);
            if (null != node) {
                node.value = value;
                del(node);
                add(node);
            } else {
                if (size < maxSize) {
                    size++;
                } else {
                    //删除链表尾节点
                    Node delNode = tail.pre;
                    hashMap.remove(delNode.key);
                    del(delNode);
                }
                Node newNode = new Node(key, value);
                add(newNode);
                hashMap.put(key, newNode);
            }
        }
    }
}
