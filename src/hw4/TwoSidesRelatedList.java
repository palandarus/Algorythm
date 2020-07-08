package hw4;


import java.util.NoSuchElementException;
import java.util.Objects;

public class TwoSidesRelatedList {

    private class Node {
        Cat c;
        Node next;
        Node prev;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }
    public class Iter{
        Node iterator;

        //reset();

        public void reset() {
            iterator = head;
        }

        //next();

        public Node next() {
            if (atEnd()) throw new NoSuchElementException();
            iterator = iterator.next;
            return iterator;
        }

        //getCurrent();

        public Node getCurrent() {
            return iterator;
        }

        //hasNext();
        public boolean hasNext() {
            return !atEnd();
        }

        //atEnd();
        public boolean atEnd() {
            if (iterator.next == null) return true;
            else return false;
        }


        public boolean atBegin() {
            return false;
        }

        //insertAfter();
        public void insertAfter(Cat cat) {
            Node node=new Node(cat);
            if (!atEnd()) {
                iterator.next.prev = node;
                node.next = iterator.next;
            }
            iterator.next = node;
            node.prev = iterator;
            size++;

        }

        //*insertBefore();
        public void insertBefore(Cat cat) {
            Node node=new Node(cat);
            node.next = iterator;
            if (iterator.prev == null) {
                node.prev = null;
                head=node;
            }
            else {
                node.prev=iterator.prev;
                iterator.prev.next=node;
            }
            iterator.prev=node;
            size++;
        }


        //deleteCurrent();
        public Cat deleteCurrent(){
            Node temp=iterator;
            if (iterator==null) throw new NoSuchElementException();
            if(atEnd()){
                if (iterator.prev==null){
                    head=null;
                    size--;
                    reset();
                }
                else{
                    iterator=iterator.prev;
                    iterator.next=null;
                    size--;
                }
            }
            else {
                if(iterator.prev==null){
                    head=iterator.next;
                    head.prev=null;
                    reset();
                    size--;
                }
                else{
                    iterator.prev.next=iterator.next;
                    iterator.next.prev=iterator.prev;
                    size--;
                }
            }
            return temp.c;
        }
    }


    private Node head;
    private int size;
    private Iter iter;

    public TwoSidesRelatedList() {
        head = null;
        size = 0;
        iter=new Iter();
        iter.reset();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Cat c) {
        Node n = new Node(c);
        if (!isEmpty()) head.prev = n;
        n.next = head;
        head = n;
        size++;
        iter.reset();
    }

    public Cat pop() {
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        if (head.next != null) head.prev = null;
        size--;
        iter.reset();
        return temp;
    }

    public Iter getIter() {
        return iter;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        return find(c) == null;
    }

    private Node find(Cat c) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean delete(Cat c) {
        Node current = head;
        Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
            head.prev = null;
        } else {
            previous.next = current.next;
            previous.next.prev = previous;
        }
        iter.reset();
        return true;
    }
}
