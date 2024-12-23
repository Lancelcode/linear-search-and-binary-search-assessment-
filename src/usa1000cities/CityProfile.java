package usa1000cities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author duncanwalker
 */

public class CityProfile implements Comparator<CityProfile>
{
    private String city;
    private double growth;
    private double latitude;
    private double longitude;
    private int population;
    private int rank;
    private String state;

    public CityProfile() 
      {
        
      }

    public CityProfile(String city, double growth, double latitude, 
                       double longitude, int population, 
                       short rank, String state) 
      {
        this.city = city;
        this.growth = growth;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.rank = rank;
        this.state = state;
      }

    @Override
    public String toString() 
     {
        String f1 ;
        String f2 ;
        String f3 ;
        String f4 ;
        String f5 ;
        String f6 ;
         
        NumberFormat nf = new DecimalFormat("#0.00");
        
        
        f1 = String.format("%8s",nf.format(this.latitude));
        f2 = String.format("%10s",nf.format(this.longitude));
        f3 = String.format("%-24s",this.city);
        f4 = String.format("%8s",nf.format(this.growth));
        f5 = String.format("%8s",this.population);
        f6 = String.format("%-20s",this.state);
        
        String result = "latitude "+f1+"  longitude "+f2+"  city  "+f3
                         + "  growth " + f4 +"  Population  " + f5 + "  State  "+f6; 
                      

        return result;
         
 
     }

    
    
    
    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CityProfile other = (CityProfile) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(double growth) {
        this.growth = growth;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
   
    @Override
     public int compare(CityProfile g1, CityProfile g2)
     {
       return g1.getCity().compareTo(g2.getCity());
     }
    
}
