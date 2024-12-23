package usa1000cities;

/**
 *
 * @author duncanwalker
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;


public class ECFile 
 {
  public  ECFile()
    {
     System.out.println("Loading Data !!");  
    }
    
  //-------------------------------------------------------------
  
  
  public CityProfile[] upDate(String filename)
  {
       String line;
       String label;
       File myFile = new File(filename) ; 
       NumberFormat nf = new DecimalFormat("#0.00");
        
       ArrayList<CityProfile> arrList = new ArrayList<>();

     try
      {
        FileReader fr = new FileReader(myFile); 
        BufferedReader br = new BufferedReader(fr);
        
        System.out.println("\nReading file\n");
        while( (line = br.readLine())!= null)
        {
            
         // System.out.println("data : "+line);  
          StringTokenizer st = new StringTokenizer(line,","); 
         
          while(st.hasMoreTokens())
          { 
  
            CityProfile cp = new CityProfile();
            cp.setCity(st.nextToken().trim());
            cp.setGrowth(Double.parseDouble(st.nextToken()));
            cp.setLatitude(Double.parseDouble(st.nextToken()));
            cp.setLongitude(Double.parseDouble(st.nextToken()));
            cp.setPopulation(Integer.parseInt(st.nextToken()));  
            cp.setState(st.nextToken().trim());
            arrList.add(cp);
          }  
        }  
     } 
     catch(IOException e)
     {
      System.out.println("An  error occured while reading a file");  
     }

     System.out.println("\n\n*********************************");

       // Use iterator to display contents of arrList
      System.out.print("Original contents of arrList: ");
      Iterator itr = arrList.iterator();
      
      System.out.println();
     
      while(itr.hasNext()) 
       {
        Object element = itr.next();
        System.out.print(element + " \n");
       }
      System.out.println();
      
      
      
       
      System.out.println("number on file is "+arrList.size());
      CityProfile myArray[] = new  CityProfile[arrList.size()];
      myArray = arrList.toArray(myArray);
      
      CityProfile[] result = new  CityProfile[myArray.length];
      for (int k = 0; k < myArray.length; k++) 
       {
	 result[k] = myArray[k];
       }

      return result;

    }  
  
}
  
 

