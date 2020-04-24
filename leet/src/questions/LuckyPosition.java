package questions;

/**
 * @author bockey
 */
public class LuckyPosition {

    public static void main(String[] args) {
//        System.out.println("5|4".substring(0, 1));
//        System.out.println("5|4".substring(2));
        int[] a = {0, 0};
        int[] b = {0, 1};
        int[] c = {0, 2};
        int[] d = {0, 3};
        int[] e = {1, 1};
        int[] f = {1, 2};
        int[] g = {-1, 1};
        int[] h = {-1, 2};
        count(8, a, b, c, d, e, f, g, h);
    }

    public static void count(int n, int[]... k) {
        int count = 0;
        for (int[] ints : k) {
            int x = ints[0];
            int y = ints[1];
            if (checkLucky(x, y, k)) count++;
        }
        System.out.println(count);
    }

    public static boolean checkLucky(int x, int y, int[]... k) {
        int maxX = x;
        int maxY = y;
        int minX = x;
        int minY = y;
        for (int[] ints : k) {
            int x1 = ints[0];
            int y1 = ints[1];
            if (x1 == x) {
                if (y > y1) {
                    maxY = Math.max(y, maxY);
                    minY = Math.min(minY, y1);
                } else {
                    maxY = Math.max(maxY, y1);
                    minY = Math.min(y, minY);
                }
            }
            if (y1 == y) {
                if (x > x1) {
                    maxX = Math.max(x, maxX);
                    minX = Math.min(minX, x1);
                } else {
                    maxX = Math.max(maxX, x1);
                    minX = Math.min(x, minX);
                }
            }
        }
        return maxY != y && minY != y && maxX != x && minX != x;
    }

}



