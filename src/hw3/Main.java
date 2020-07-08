package hw3;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 2. Создать класс для реализации дека.
 * 3. Реализовать класс с приоритетной очередью
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String str = "start";
        Stack stack = new Stack(1);

        System.out.println("ex.1 Input string to reverse ");
        str = scanner.nextLine();
        stack.push(str);
        stack.printChar();

        System.out.println("ex.2 We have a deque:");
        Deque deque = new Deque(11);
        for (int i = 0; i < 10; i++) {
            deque.insert(i);
        }
        deque.print();
        System.out.println("insert first element - 99");
        deque.insertFirst(99);
        System.out.println("insert last element - 10");
        deque.insert(10);
        deque.print();
        System.out.println("ex.3 We have a priorityQueue:");
        PriorityQueue priorityQueue = new PriorityQueue(10);
        for (int i = 0; i < 10; i++) {
            priorityQueue.insert(10 - i);
        }
        priorityQueue.print();
        System.out.println("insert element with priority 5");
        priorityQueue.insert(5);
        priorityQueue.print();
        System.out.println("insert element with priority 99");
        priorityQueue.insert(99);
        priorityQueue.print();
        System.out.println("Delete first item");
        System.out.println(priorityQueue.remove());
        priorityQueue.print();
    }


}
