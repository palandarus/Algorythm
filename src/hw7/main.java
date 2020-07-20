package hw7;

public class main {
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addVertex('0');
        graph.addVertex('1');
        graph.addVertex('2');
        graph.addVertex('3');
        graph.addVertex('4');
        graph.addVertex('5');
        graph.addVertex('6');
        graph.addVertex('7');
        graph.addVertex('8');
        graph.addVertex('9');
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(2,7);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,9);
        graph.addEdge(3,4);
        graph.addEdge(9,4);
        graph.addEdge(9,8);
        graph.addEdge(4,8);
        graph.addEdge(8,5);
        graph.addEdge(8,6);
        graph.addEdge(5,7);

        graph.depthTraverse();

        graph.widthTraverse(5);

    }
}
