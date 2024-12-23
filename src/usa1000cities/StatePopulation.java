
package usa1000cities;

import java.util.Comparator;


public class StatePopulation implements Comparator<CityProfile>
{
    
 public StatePopulation() {}

   @Override
    public int compare(CityProfile g1, CityProfile g2)
     {
      String st1;
      String st2;
      String st3;
      String st4;
      
      int num1 = g1.getPopulation();
      int num2 = g2.getPopulation();
      
      st3 = String.format("%07d", num1);
      st4 = String.format("%07d", num2);
      

      st1 = g1.getState().concat(st3);
      st2 = g2.getState().concat(st4);
      
      return st1.compareTo(st2);
     } 
}