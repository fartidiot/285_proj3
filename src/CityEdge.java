 /*
  * Title:          PACKAGE_NAME
  * Authors:        Miles Maloney, Caden Keese
  * Last Modified:  2019-05-02
  * Description:
  * */

 public class CityEdge {
     private int cost;
     private String destination;
     private CityEdge next;

     // Constructors
     public CityEdge(String destination, int cost) {
         this.cost = cost;
         this.destination = destination;
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

     // Setters

     public void setNext(CityEdge next) {
         this.next = next;
     }
 }
