package hw3;

import java.util.NoSuchElementException;

public class Deque extends Queue{

    public Deque(int capacity) {
        super(capacity);
    }
    public int peekLast(){
        if(isEmpty()) return queue[head];
        else return queue[tail];
    }
    public void insertFirst(int value){
        if (isFull()) {
            capacity *= 2;
            int[] newQ = new int[capacity];
            if (tail >= head) {
                System.arraycopy(queue, 0, newQ, 1, queue.length);
            } else{
                System.arraycopy(queue, 0, newQ, 0, tail + 1);
                System.arraycopy(queue, head,
                        newQ, capacity - (queue.length - head),
                        queue.length - head - 1);
                head--;
            }
            queue = newQ;
        }
        if (tail == capacity - 1)
            tail = -1;
        queue[head] = value;
        tail++;
        items++;
    }
    public int removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[tail--];
        items--;
        return temp;
    }



}
