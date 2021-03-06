package hw3;

import java.util.NoSuchElementException;

public class Queue {
    protected int capacity;
    protected int[] queue;
    protected int head;
    protected int tail;
    protected int items;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }

    public void insert(int value) {
        if (isFull()) {
            capacity *= 2;
            int[] newQ = new int[capacity];
            if (tail >= head) {
                System.arraycopy(queue, 0, newQ, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, newQ, 0, tail + 1);
                System.arraycopy(queue, head,
                        newQ, capacity - (queue.length - head),
                        queue.length - head - 1);
            }
            queue = newQ;
        }
        if (tail == capacity - 1)
            tail = -1;
        queue[++tail] = value;
        items++;
    }

    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[head++];
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        return temp;
    }

    public int peek() {
        return queue[head];
    }

    public void print() {
        for (int i = 0; i < items; i++) {
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }

    //t[h.........]
    // [h||||||t..]
    // [....h||t..]
    // [|t..h|||||]
    // [|t..................]

}
