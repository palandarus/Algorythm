package hw2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Array {

    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    private void generate(int capacity) {
        for (int i = 0; i < capacity; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }
    }

    public Array clone() {
        return new Array(Arrays.copyOf(this.arr, this.arr.length));
    }

    public Array(int capacity, boolean generate) {
        this();
        arr = new int[capacity];
        if (generate) {
            generate(capacity);
            size = capacity;
        }

    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);

        return arr[--size];
    }

    public void deleteIndex(int index){
        int newSize=--size;
        int[] newArr=new int[newSize];
        System.arraycopy(this.arr,0,newArr,0,index-1);
        System.arraycopy(this.arr,index,newArr,index-1,(this.arr.length-index));
        this.arr=newArr;

    }

    // homework
    // insert(index, value);
    // delete(val);
    // delete(index);
    // deleteAll();

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        int count = 0;
        long time = System.nanoTime();

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
        time = System.nanoTime() - time;
        System.out.printf("SortBubble Elapsed %,9.3f ms Count = %d\n", time / 1_000_000.0, count);
    }

    public void mysortBubble() {
        int count = 0;
        long time = System.nanoTime();
        boolean wasSwapped = false;


        for (int i = 0; i < size / 2; i++) {
            if (i > 0 && !wasSwapped)
                break;
            wasSwapped = false;
            for (int j = i; j < size - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    wasSwapped = true;
                }

            }
            for (int z = size - i - 2; z > i; z--) {
                count++;
                if (arr[z] < arr[z - 1]) {
                    swap(z, z - 1);
                    wasSwapped = true;
                }
            }
        }


        isSorted = true;
        time = System.nanoTime() - time;
        System.out.printf("MySortBubble Elapsed %,9.3f ms Count = %d\n", time / 1_000_000.0, count);
    }

    public void sortSelect() {
        int count = 0;
        long time = System.nanoTime();
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                count++;
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
        time = System.nanoTime() - time;
        System.out.printf("SortSelect Elapsed %,9.3f ms Count = %d\n", time / 1_000_000.0, count);
    }

    public void sortInsert() {
        int count = 0;
        long time = System.nanoTime();
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
                count++;
            }
            arr[in] = temp;
        }
        isSorted = true;
        time = System.nanoTime() - time;
        System.out.printf("SortInsert Elapsed %,9.3f ms Count = %d\n", time / 1_000_000.0, count);
    }

    public void countSort() {
        int count=0;
        long time = System.nanoTime();
        int min, max;
        min = max = this.arr[0];
        for (int i = 0; i < this.arr.length; i++) {
            count++;
            if (min > this.arr[i]) min = this.arr[i];
            if (max < this.arr[i]) max = this.arr[i];
        }
        int arrCountSort[] = new int[max + 1];

        for (int i = 0; i < this.arr.length; i++) {
            count++;
            arrCountSort[this.arr[i]]++;
        }
        int countArrItem = 0;
        for (int i = 0; i < arrCountSort.length; i++) {
            for (int j = arrCountSort[i]; j > 0; j--) {
                count++;
                arr[countArrItem] = i;
                countArrItem++;
            }
        }


        isSorted = true;
        time = System.nanoTime() - time;
        System.out.printf("countSort Elapsed %,9.3f ms Count = %d\n", time / 1_000_000.0, count);

    }
}
