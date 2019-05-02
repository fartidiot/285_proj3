 /*
  * Title:          PACKAGE_NAME
  * Authors:        Miles Maloney, Caden Keese
  * Last Modified:  2019-05-02
  * Description:
  * */

 public class CityGraph {
  private String[] cityNames;
  private CityEdge[] edges;

  public CityGraph(String[] cityNames) {
   this.cityNames = cityNames;
   this.cityNames = new String[cityNames.length];
  }

  private int indexOf(String city){
   for(int i = 0; i < cityNames.length; i++){
     if(city.equals(cityNames[i])) return i;
   }
   return -1;
  }


  public void addEdge(String origin, String dest, int cost){
   int oi = indexOf(origin);
   if(oi == -1) throw new IndexOutOfBoundsException(origin +" Does Not Exist in cityFile!");
   CityEdge e = new CityEdge(dest, cost);
   if(edges[oi] == null){
    edges[oi] = e;
   }else{
    e.setNext(edges[oi].getNext());
    edges[oi].setNext(e);
   }
  }

  public void  addEdgeFromArray(String[] a){
   addEdge(a[0], a[1], Integer.parseInt(a[2]));
  }


 }
