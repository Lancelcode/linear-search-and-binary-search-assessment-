package usa1000cities;

import java.util.Comparator;

/**
 *
 * @author duncanwalker
 */

public class CityComparator implements Comparator<CityProfile>
{
  public CityComparator(){}

   @Override
    public int compare(CityProfile g1, CityProfile g2)
     {
      return g1.getCity().compareTo(g2.getCity());
     } 
}