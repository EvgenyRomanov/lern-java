package algorithms_and_data_structures;

public class BigO {
    /*
        Бинарный поиск  - O(log N)
        Хеш-таблица - O(1)
     */


    /**
     * O(1) - время работы.
     */
    public static int f1(int[] a) {
        return a.length * 7 + 16;
    }

    /**
     * O(N).
     */
    public static int f2(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;
    }

    /**
     * O(N^2).
     */
    public static int f3(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                sum += a[i] * a[j];
            }
        }

        return sum;
    }

    /**
     * O(N^2). Константа перед N^2 отбрасывается, остается только та часть, которая вносит наибольший вклад.
     */
    public static int f4(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                sum += a[i] * a[j];
            }
        }

        return sum;
    }

    /**
     * O(N). Константа перед N отбрасывается.
     */
    public static int f5(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 100; j++) {
                sum += a[i] * j;
            }
        }

        return sum;
    }

    /**
     * O(log N).
     */
    public static int f6(int x) {
        int sum = 0;

        while (x > 0) {
            sum += x % 2;
            x /= 2;
        }

        return sum;
    }

    /**
     * O(N log N).
     */
    public static int f7(int x) {
        int sum = 0;

        for (int i = 0; i < x; i++) {
            int t = x;
            while (t > 0) {
                sum += t % 2;
                t /= 2;
            }
        }

        for (int i = 0; i < x; i++) {
            sum += i;
        }

        return sum;
    }

    /**
     * O(N^2).
     */
    public static int f8(int x) {
        int sum = 0;

        for (int i = 0; i < x; i++) {
            int t = x;
            while (t > 0) {
                sum += t % 2;
                t /= 2;
            }

            for (int j = 0; j < x; j++) {
                for (int k = 0; k < 10; k++) {
                    sum += i;
                }
            }
        }

        return sum;
    }
}
