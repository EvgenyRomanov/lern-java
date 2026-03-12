package algorithms_and_data_structures;

/**
 * Сдвиг массива.
 */
public class ArrayShift {

    static void main(String[] args) {
        int[] array = new int[]{ 15, 23, 20, 5, 15, 20, 15, 20 };
        var newLength = removeDuplicates(array);

        for (int i = 0; i < newLength; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Удаление элемента из массива, не создавая при этом новый массив.
     */
    public static int removeElementAtIndex(int[] array, int element) {
        for (int i = element + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }

        return array.length - 1;
    }

    /**
     * Удаление дубликатов без выделения дополнительного массива.
     */
    public static int removeDuplicates(int[] array) {
        int length = array.length;
        int i = 0;

        while (i < length) {
            boolean found = false;

            for (int k = i + 1; k < length; k++) {
                if (array[i] == array[k]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                i++;
            } else {
                // Удаление сдвигом.
                for (int k = i + 1; k < length; k++) {
                    array[k - 1] = array[k];
                }
                length--;
            }
        }

        return length;
    }
}
