package algorithms_and_data_structures;

/**
 * Амортизационное время O(1) добавления в конец и удаления с конца.
 */
public class DynamicArray {
    int[] data;
    int length;

    public DynamicArray() {
        this.data = new int[1];
        int length = 0;
    }

    public int size() {
        return this.length;
    }

    public void set(int ind, int value) {
        this.data[ind] = value;
    }

    public int get(int ind) {
        return this.data[ind];
    }

    public void add(int x) {
        if (this.length == this.data.length) {
            int[] data2 = new int[this.length * 2];

            for (int i = 0; i < this.length; i++) {
                data2[i] = data[i];
            }

            this.data = data2;
        }

        this.data[this.length] = x;
        this.length += 1;
    }

    /**
     * 1) не менять размер массива
     * 2) уменьшать размер, когда 1/4 заполнена
     */
    public void remove() {
        this.length -= 1;
        if (this.length * 4 < this.data.length) {
            int[] data2 = new int[this.data.length / 2];

            for (int i = 0; i < this.length; i++) {
                data2[i] = data[i];
            }

            this.data = data2;
        }
    }

    /**
     * Вставка в середину O(N).
     */
    public void insert(int x, int ind) {
        this.add(0);
        for (int i = this.length - 1; i > ind; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[ind] = x;
    }
}
