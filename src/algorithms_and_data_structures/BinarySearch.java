package algorithms_and_data_structures;

/**
 * Алгоритм бинарный поиск (в отсортированном массиве).
 * N элементов = 2^X итераций (степени двойки).
 * X = log2N (по основанию 2), логарифмическая сложность.
 */
public class BinarySearch {
    public static void main(String[] args) {

    }

    public static int binarySearch(int[] array, int search) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {
            if (array[middle] < search) {
                left = middle + 1;
            } else if (array[middle] > search) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
