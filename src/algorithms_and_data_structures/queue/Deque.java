package algorithms_and_data_structures.queue;

public class Deque {
    int[] data;
    int head;
    int tail;

    public Deque(int maxSize) {
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

    public void doubleSize() {
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

    public void pushBack(int x) {
        if ((tail + 1 == head) || ((tail + 1 == data.length) && (head == 0))) {
            doubleSize();
        }

        data[tail] = x;
        tail += 1;

        if (tail >= data.length) {
            tail = 0;
        }
    }

    public void pushFront(int x) {
        int prev = head - 1;
        if (prev < 0) {
            prev = data.length - 1;
        }

        if (prev == tail) {
            doubleSize();
            prev = data.length - 1;
        }
        data[prev] = x;
        head = prev;
    }

    public int popBack(int x) {
        if (empty()) {
            System.out.println("Popping from empty deque");
            return -1;
        }
        int prev = tail - 1;
        if (prev < 0) {
            prev = data.length;
        }

        int t = data[prev];
        data[prev] = 0;
        tail = prev;

        return t;
    }

    public int popFront(int x) {
        if (empty()) {
            System.out.println("Popping from empty deque");
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
}
