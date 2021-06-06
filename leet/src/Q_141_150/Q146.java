package Q_141_150;

import java.util.HashMap;
import java.util.LinkedList;

/**
 执行用时：17 ms, 在所有 Java 提交中击败了98.84% 的用户
 内存消耗：46.1 MB, 在所有 Java 提交中击败了93.44% 的用户
 */
public class Q146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 3);
        cache.get(1);
        cache.get(2);

    }
}

class LRUCache {
    class Node {
        int key;
        int val;

        Node next;
        Node prev;

        Node removeSelf() {
            if (this.prev != null) {
                this.prev.next = this.next;
                if (this.next != null) {
                    this.next.prev = this.prev;
                }
            }
            return this;
        }
    }

    int cap = 0;
    int size = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.removeSelf();
        node.next = head.next;
        if (head.next != null) {
            head.next.prev = node;
        } else {
            head.next = node;
            node.prev = head;
            tail = node;
        }
        node.prev = head;
        head.next = node;
        return node.val;
    }

    public void put(int key, int value) {
        Node cur = new Node();
        cur.val = value;
        cur.key = key;
        if (map.get(key) != null) {
            Node old = map.get(key);
            if (old == tail) {
                tail = tail.prev;
            }
            old.removeSelf();
            size--;
        }
        map.put(key, cur);
        if (head.next != null) {
            head.next.prev = cur;
            cur.next = head.next;
            cur.prev = head;
            head.next = cur;
        } else {
            head.next = cur;
            cur.prev = head;
            tail = cur;
        }
        size++;
        if (size > cap) {
            Node toRemove = tail;
            if (tail != null) {
                tail = tail.prev;
                toRemove.removeSelf();
                map.remove(toRemove.key);
                size--;
            }
        }
    }
}
