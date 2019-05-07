// /*
//  * Title:          PACKAGE_NAME
//  * Authors:        Miles Maloney, Caden Keese
//  * Last Modified:  2019-05-04
//  * Description:
//  * */
//
// class Node {
//     private int value;
//     private Node next;
//
//     public Node(int value) {
//         this.value = value;
//         this.next = null;
//     }
//
//     //getters
//     public int getIndex() {
//         return value;
//     }
//
//     public Node getNext() {
//         return next;
//     }
//     //setters
//
//     public void setNext(Node next) {
//         this.next = next;
//     }
// }
//
//
// public class Queue {
//     private Node head;
//     private Node tail;
//
//     public void enqueue(int value) {
//         Node n = new Node(value);
//         if (head == null) {
//             head = n;
//             tail = head;
//         }
//         n.setNext(this.head);
//         this.head = n;
//     }
//
//     public boolean isEmpty() {
//         return (tail == null);
//     }
//
//     public int dequeue() throws IndexOutOfBoundsException
//     {
//         if (this.isEmpty()) throw new IndexOutOfBoundsException("Queue is empty");
//
//         int temp = tail.getIndex();
//         tail = tail.getNext();
//         return temp;
//     }
// }