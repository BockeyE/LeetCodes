package questions;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        int[] arr = {1,6,4,78,3,2,4,7,5};
        qsort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void qsort(int[] arr, int head, int tail) {
        if (head < tail) {
            int piv = qsortPiv(arr, head, tail);
            qsort(arr, head, piv);
            qsort(arr, piv + 1, tail);
        }
    }

    public static int qsortPiv(int[] arr, int head, int tail) {
        int piv = arr[head];
        while (head < tail) {
            while (head < tail && arr[tail] >= piv) {
                tail--;
            }
            arr[head] = arr[tail];
            while (head < tail && arr[head] <= piv) {
                head++;
            }
            arr[tail] = arr[head];
        }
        arr[head] = piv;
        return head;
    }
}
