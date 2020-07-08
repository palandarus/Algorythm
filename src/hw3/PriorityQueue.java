package hw3;

public class PriorityQueue extends Queue{


    public PriorityQueue(int capacity) {
        super(capacity);

    }

    @Override
    public void insert(int value) {
        if(isFull()){
        capacity++;
        int[] newQ=new int[capacity];
        System.arraycopy(queue,0,newQ,0,queue.length);
        queue=newQ;
        }
        int pos=0;
        if(!isEmpty()) {

            for (pos = 0; pos < items; pos++) {
                if (queue[pos] > value) break;
            }
            System.arraycopy(queue,pos,queue,pos+1,items-pos);
        }

        queue[pos]=value;
        items++;
    }


    public int remove() {
        int deletedItem=0;
        if(isEmpty()) new IndexOutOfBoundsException("Queue is empty");
        else {
            int[] newQ=new int[--capacity];
            deletedItem=queue[0];
            items--;
            System.arraycopy(queue,1,newQ,0,items);
            queue=newQ;
        }
        return deletedItem;
    }
}
