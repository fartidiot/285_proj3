 /*
  * Title:          Project 3
  * Authors:        Miles Maloney, Caden Keese
  * Last Modified:  2019-05-06
  * Description: A modified node class to hold info
  * */

 public class CityEdge {
     private int cost;
     private String destination;
     private CityEdge next;
     private int index;

     // Constructors
     public CityEdge(String destination, int cost, int index) {
         this.cost = cost;
         this.destination = destination;
         this.index = index;
     }

     // Getters

     public int getCost() {
         return cost;
     }

     public String getDestination() {
         return destination;
     }

     public CityEdge getNext() {
         return next;
     }

     public int getIndex() {
         return index;
     }

     // Setters

     public void setNext(CityEdge next) {
         this.next = next;
     }


     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb
           .append("\t-> ")
           .append(destination)
           .append(":")
           .append(cost)
           .append("\n");
         if(next != null){
             sb.append(next.toString());
         }
         return sb.toString();
     }


 }
