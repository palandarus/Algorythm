package hw2;

/**
 * Дописать методы удаления в классе массива
 * Улучшить пузырьковую сортировку
 * Подсчитать количество операций в сортировках и сравнить с их О-большое
 * Реализовать сортировку подсчётом
 * */

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr; // int arr[]
        arr = new int[5];
        int[] arr2 = {1, 2, 3, 4};

        Array a1 = new Array(800, true);
        Array a2 = a1.clone();
        Array a3 = a1.clone();
        Array a4 = a1.clone();
        a1.sortBubble();
        System.out.println(a1);
        a2.mysortBubble();
        System.out.println(a2);
        a3.sortInsert();
        System.out.println(a3);
        a4.sortSelect();
        System.out.println(a4);

    }
}
