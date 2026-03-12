package algorithms_and_data_structures.hash_table_and_hash_func;

public class HashMap {
    class KeyValuePair {
        public String key;
        public String value;

        public KeyValuePair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    KeyValuePair[] entries = new KeyValuePair[8];
    int size = 8;
    int numberOfElements = 0;

    int hashFunction(String key) {
        return 0;
    }

    public void add(String key, String value) {
        int index = findGoodIndex(key);
        entries[index] = new KeyValuePair(key, value);
        numberOfElements++;

        if (numberOfElements == size) {
            resize(size * 2);
        }
    }

    public void resize(int newSize) {
        KeyValuePair[] newEntries = new KeyValuePair[newSize];

        for (int i = 0; i < size; i++) {
            KeyValuePair entry = entries[i];
            int newIndex = findGoodIndex(entry.key);
            newEntries[newIndex] = entry;
        }

        entries = newEntries;
        size = newSize;
    }

    public String get(String key) {
        int index = findGoodIndex(key);
        if (index == -1) {
            return null;
        }

        KeyValuePair entry = entries[index];
        if (entry == null) {
            return null;
        }

        return entry.value;
    }

    // Линейное пробирование (в случае коллизии).
    int findGoodIndex(String key) {
        int hash = hashFunction(key);
        int index = hash % size; // Приводим хэш к размеру массива.

        // Цикл всегда вернет значение.
        for (int i = 0; i < size; i++) {
            int probingIndex = (index + i) % size;
            KeyValuePair entry = entries[probingIndex];

            if (entry == null || entry.key.equals(key)) {
                return probingIndex;
            }
        }

        return -1; // Для компилятора.
    }
}
