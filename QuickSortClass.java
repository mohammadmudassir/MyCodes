/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortclass;
import java.util.Scanner;
/**
 *
 * @author Muzammil
 */
class QuickSort
{
    public void quickSortFun(int [] arr, int start, int end)
    {
        if(start<end)
        {
            int pivotLoc=findPivotLoc(arr,start,end);
            quickSortFun(arr,start,pivotLoc-1);
            quickSortFun(arr,pivotLoc+1,end);
        }
    }
    public int findPivotLoc(int [] arr,int start,int end)
    {
        int i=start;    //storing the starting index of array
        int j=end;     //storing the last index of array
        int loc=start;  //consider the first element location as a pivot location
        while(true)
        {
            while(arr[loc]<arr[j] && loc!=j)
            {
                j--;
            }
            if(loc==j)
                return loc;
            if(arr[loc]>arr[j])
            {
               int swap=arr[loc];
               arr[loc]=arr[j];
               arr[j]=swap;
            }
            while(arr[loc]>arr[i] && loc!=i)
            {
                i++;
            }
            if(loc==i)
                return loc;
            if(arr[loc]<arr[i])
            {
               int swap=arr[loc];
               arr[loc]=arr[i];
               arr[i]=arr[loc];
            }
        }
    }
}
public class QuickSortClass {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QuickSort obj=new QuickSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("How many numbers do you want to enter : ");
        int [] arr=new int[sc.nextInt()];
        System.out.println("Enter the array which you want to sort : ");
        for(int i=0;i<arr.length;i++)
        {
           arr[i]=sc.nextInt();
        }
        
        obj.quickSortFun(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+",");
        }
    }   
}
