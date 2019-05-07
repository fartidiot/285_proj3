import java.util.EmptyStackException;

/*
 * Title:          PACKAGE_NAME
 * Authors:        Miles Maloney, Caden Keese
 * Last Modified:  2019-05-04
 * Description:
 * */
class Node {
    private int index;
    private Node next;
    private int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
        this.next = null;
    }

    //getters
    public int getIndex() {
        return index;
    }

    public Node getNext() {
        return next;
    }
    //setters

    public void setNext(Node next) {
        this.next = next;
    }

    public int getCost() {
        return cost;
    }
}

public class Stack {

    private Node head;
    private int size = 0;

    public void push(int index, int cost) {
        Node n = new Node(index, cost);
        if (this.head != null) {
            n.setNext(this.head);
        }
        this.head = n;
        this.size++;
    }

    public Integer peek() {
        return head.getIndex();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Integer pop() {
        return popNode().getIndex();
    }

    public Node popNode() {
        if (isEmpty()) throw new EmptyStackException();
        this.size--;
        Node temp = this.head;
        this.head = this.head.getNext();
        return temp;
    }

    public void pushEdge(CityEdge e) {
        push(e.getIndex(), e.getCost());
    }

    public int getSize() {
        return size;
    }
}
