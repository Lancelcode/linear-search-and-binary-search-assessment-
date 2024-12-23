package usa1000cities;

import java.util.Comparator;


/**
 *
 * @author DuncanWalker
 */

public class MergeSort 
{
  public MergeSort() {}  
  
  public void displayArray(Comparator[] array , String message)
   {
      System.out.println("\n------------------------------"); 
      System.out.println(message +"\n");
      
      for(int k =0; k <array.length; k++)
       {
        System.out.print(array[k]+" "); 
       }
      System.out.println("\n------------------------------\n\n"); 
  }

  public void mergeSort(Comparator[] a,Comparator comp)
    {
        
      Comparator[] temp = new Comparator[a.length];
      mergeSort(a,temp,comp,0,a.length-1);  
    }

  public void mergeSort(Comparator[] a,Comparator[] temp,Comparator comp,int left,int right)
    {
       if(left < right)
        {
          int center =(left+right)/2;
          
          mergeSort(a,temp,comp,left,center);
          mergeSort(a,temp,comp,center+1,right); 
          merge(a,temp,comp,left,center+1,right); 
        }
    }

  public void merge(Comparator[] a,Comparator[] temp,Comparator comp ,int left,int right,int rightend)
    {
     int leftend = right-1;
     int k = left;
     int num = rightend-left+1;
     
     while( left<=leftend && right <= rightend)
     {
       if(comp.compare(a[left],a[right])<0)
        {
          temp[k++]=a[left++];          
        }
       else
        {
          temp[k++]=a[right++];   
        }  
     }
     
     while(left<=leftend) 
      {
       temp[k++]=a[left++];  
      }
     
     while(right<=rightend) 
      {
        temp[k++]=a[right++];  
      }
     
     for(int m =0; m<num; m++, rightend--)
      {
        a[rightend] = temp[rightend];  
      }
        
    }
}
