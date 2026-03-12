package algorithms_and_data_structures.hash_table_and_hash_func;

public class HashFunction {
    static int[] values1 = new int[8];
    static int[] values2 = new int[40];

    static void main(String[] args) {
        // Ия:14
        // Аня:99
        // Миша:30
        // Антон:42
        // Владик:87
        // Николай:71
        values1[2] = 14;
        values1[3] = 99;
        values1[4] = 30;
        values1[5] = 42;
        values1[6] = 87;
        values1[7] = 71;

        // или

        /*
            79101002030: 900
            79101234567: 100
            79999999999: 999
            74952223344: 1
            ...
            всего 40 номеров
         */

        values2[30] = 900; // 79101002030 % 40 = 30
        values2[7] = 100;
        values2[39] = 999;
        values2[24] = 1;
    }

    // Пример примитивной хэш-функции (но возможны случаи, когда для разных ключей будет одинаковый индекс).
    public int getIndexByKey(String key) {
        return key.length();
    }

    public int getValueByKey(String key) {
        int index = getIndexByKey(key);
        return values1[index];
    }

    // ---------------
    // Пример примитивной хэш-функции (но возможны случаи, когда для разных ключей будет одинаковый индекс).
    public int getIndexByKey(int key) {
        return key % 40;
    }

    public int getValueByKey(int key) {
        int index = getIndexByKey(key);
        return values2[index];
    }
}
