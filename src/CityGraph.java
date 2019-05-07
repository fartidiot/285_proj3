 /*
  * Title:          Project 3
  * Authors:        Miles Maloney, Caden Keese
  * Last Modified:  2019-05-06
  * Description: An array of linked lists to model a graph, has the ability to use breadth first search
  * */

 import java.util.Arrays;

 public class CityGraph {
     private String[] names;
     private CityEdge[] edges;

     public CityGraph(String[] names) {
         this.names = names;
         this.edges = new CityEdge[names.length];
     }

     public int indexOf(String city) {
         int index = Arrays.binarySearch(this.names, city);
         if (index < 0) {
             return -1;
         } else {
             return index;
         }
     }

     private void addEdge(String origin, String dest, int cost) {
         int oi = indexOf(origin);
         int od = indexOf(dest);
         if (oi == -1) throw new IndexOutOfBoundsException(origin + " Does Not Exist in cityFile!");
         CityEdge e = new CityEdge(dest, cost, od);
         if (this.edges[oi] == null) {
             this.edges[oi] = e;
         } else {
             e.setNext(this.edges[oi].getNext());
             this.edges[oi].setNext(e);
         }
     }

     public void addEdgeFromArray(String[] a) {
         addEdge(a[0], a[1], Integer.parseInt(a[2]));
     }

     public void debug() {
         for (int i = 0; i < names.length; i++) {
             System.out.println(names[i]);
             System.out.println(edges[i]);
         }
     }

     public void calculatePath(String origin, String dest) {
         int OI = indexOf(origin);
         int DI = indexOf(dest);
         Stack s = new Stack();
         boolean[] visited = new boolean[names.length];
         s.push(OI, 0);
         outer:
         while (true) {
//             System.out.println("checking: " + names[s.peek()]);
             if (s.isEmpty()) {
                 System.out.println("Sorry. USAir does not fly from " + origin + " to " + dest);
                 return;
             }

             CityEdge next = edges[s.peek()];
             while (next == null || visited[next.getIndex()]) {
                 if (next == null) {
                     s.pop();
                     continue outer;
                 }
//                 System.out.println("-> checking: " + names[next.getIndex()] + "visited: " + visited[next.getIndex()]);
                 next = next.getNext();
             }
             visited[next.getIndex()] = true;
             s.pushEdge(next);
             if (next.getIndex() == DI) break;

         }
         generateItemization(s, OI, DI);
     }

     private void generateItemization(Stack s, int OI, int DI) {
         System.out.println("Request is to fly from " + names[OI] + " to " + names[DI]);
         Node[] items = new Node[s.getSize()];
         for (int i = items.length - 1; i >= 0; i--) {
             items[i] = s.popNode();
         }
         int total = 0;
         for (int i = 1; i < items.length; i++) {
             String last = names[items[i - 1].getIndex()];
             String dest = names[items[i].getIndex()];
             int cost = items[i].getCost();
             total += cost;

             StringBuilder sb = new StringBuilder();

             String s1 = sb.append("  ").append(last).append(" -> ").append(dest).toString();

             for (int j = 0; j < 40 - s1.length(); j++) sb.append(" ");

             sb.append("$").append(cost);

             System.out.println(sb);
         }
         StringBuilder sb = new StringBuilder();
         sb.append("Total Cost ");
         for (int j = 0; j < 40 - 12; j++) sb.append(".");
         sb.append(" $").append(total);
         System.out.println(sb);


     }

 }
