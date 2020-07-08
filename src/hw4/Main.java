package hw4;

/**
 * 1. Реализовать класс итератора для двусвязного списка
 * 2. Реализовать двусвязный список
 * */

public class Main {
    public static void main(String[] args) {
        TwoSidesRelatedList drl = new TwoSidesRelatedList();
        drl.push(new Cat(1, "cat1"));
        drl.push(new Cat(2, "cat2"));
        drl.push(new Cat(3, "cat3"));
        System.out.println(drl);
        drl.pop();
        System.out.println(drl);
        System.out.println(drl.getIter().getCurrent());
        System.out.println(drl.getIter().hasNext());
        //System.out.println(drl.getIter().next());
        System.out.println(drl.getIter().getCurrent());
        drl.getIter().insertBefore(new Cat(5,"cat5"));
        System.out.println(drl);
        drl.getIter().insertAfter(new Cat(6,"cat6"));
        System.out.println(drl);
        System.out.println(drl.getIter().getCurrent());
        drl.getIter().deleteCurrent();
        System.out.println(drl);
        drl.push(new Cat(4, "cat4"));
        System.out.println(drl);
        drl.delete(new Cat(4, "cat4"));
        System.out.println(drl);
    }


}
