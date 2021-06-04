package questions;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,3,1};
        System.out.println(Arrays.toString(arr));
        System.out.println("=========");

        QuickSort qs = new QuickSort();
        qs.quick(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quick(int[] arr) {
        quicks(arr, 0, arr.length - 1);
    }

    public void quicks(int[] arr, int head, int end) {
        if (head < end) {
            int piv = quickCore(arr, head, end);
            quicks(arr, head, piv);
            quicks(arr, piv + 1, end);
        }
    }

    public int quickCore(int[] arr, int head, int end) {
        int piv = arr[head];
        while (head < end) {
            while (head < end && (arr[end] >= piv)) {
                end--;
            }
            arr[head] = arr[end];
            while (head < end && (arr[head] <= piv)) {
                head++;
            }
            arr[end] = arr[head];
        }
        arr[head] = piv;
        return head;
    }
}
