package questions;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyLRU {
    public static void main(String[] args) {
        int[] a = {1, 1, 1,};
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 3, 2,};
        int[] a3 = {2, 1};
        int[] a4 = {1, 4, 4,};
        int[] a5 = {2, 2};

        int[][] p = {a, a1, a2, a3, a4, a5};
        int[] lru = LRU(p, 3);

    }

    public static int[] LRU(int[][] operators, int k) {
        // write code here
        if (operators == null) {
            return null;
        }
        LocalList<Pairs> list = new LocalList<>(k);
        ArrayList<Integer> ret = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                Pairs pairs = new Pairs(operator[1], 0);
                int indexOf = list.indexOf(pairs);
                if (indexOf == -1) {
                    ret.add(-1);
                } else {
                    pairs = list.remove(indexOf);
                    list.addFirst(pairs);
                    ret.add(pairs.v);
                }
            } else if (operator[0] == 1) {
                Pairs pairs = new Pairs(operator[1], operator[2]);
                list.addFirst(pairs);
            }
        }
        int[] r = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            r[i] = ret.get(i
            );
        }
        System.out.println(ret);
        return r;

    }

    static class LocalList<T> extends LinkedList<T> {
        int maxSize;

        LocalList(int maxSize) {
            this.maxSize = maxSize;
        }

        @Override
        public void addFirst(T t) {
            super.addFirst(t);
            if (this.size() > maxSize) {
                this.removeLast();
            }
        }
    }

    static class Pairs {
        int k;
        int v;

        Pairs(int k, int v) {
            this.v = v;
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            return this.k == ((Pairs) obj).k;
        }

        @Override
        public String toString() {
            return k + "|" + v;
        }
    }
}
