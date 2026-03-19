package algorithms_and_data_structures.queue;

/**
 * O(1) - вставка, удаление (когда список)
 *                          (для зацикленного массива амортизированная O(1))
 *                          (для двух стеков вставка - O(1), удаление - амортизированная O(1))
 */
public class Queue {
    int[] data;
    int head;
    int tail;

    public Queue(int maxSize) {
        data = new int[maxSize];
        head = 0;
        tail = 0;
    }

    public boolean empty() {
        if (head == tail) {
            return true;
        }

        return false;
    }

    public void pushBack(int x) {
        if ((tail + 1 == head) || ((tail + 1 == data.length) && (head == 0))) {
            int[] d = new int[data.length * 2];
            int pt = 0;

            if (head <= tail) {
                for (int i = head; i < tail; i++) {
                    d[pt] = data[i];
                    pt += 1;
                }
            } else  {
                for (int i = head; i < data.length; i++) {
                    d[pt] = data[i];
                    pt += 1;
                }

                for (int i = 0; i < tail; i++) {
                    d[pt] = data[i];
                    pt += 1;
                }
            }

            data = d;
            head = 0;
            tail = pt;
        }

        data[tail] = x;
        tail += 1;

        if (tail >= data.length) {
            tail = 0;
        }
    }

    public int popFront(int x) {
        if (empty()) {
            System.out.println("Popping from empty queue");
            return -1;
        }

        int t = data[head];
        data[head] = 0;
        head += 1;
        if (head >= data.length) {
            head = 0;
        }
        return t;
    }

    public int peek() {
        return data[head];
    }
}
