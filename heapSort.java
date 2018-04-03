/*
 * To change this l`icense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;
import java.util.Scanner;
/**
 *
 * @author Muzammil
 */
class BuildHeap
{
    //public int [] harr;
    //build heap function iteratively 
    /*
    public void buildHeap(int [] harr,int len)
    {
        for(int i=1;i<len;i++)
        {
            if(harr[i]<harr[(i-1)/2])
            {
                swap(harr,i,(i-1)/2); 
                buildHeapUtil(harr,(i-1)/2);
            }       
        }
    }
    */
    //build heap function using recursion
    public void buildHeapRecur(int [] harr,int i,int len)
    {
        if(i>=len) return ;
        if(harr[i]<harr[(i-1)/2])
        {
            swap(harr,i,(i-1)/2); 
            buildHeapUtil(harr,(i-1)/2);
        }  
        buildHeapRecur(harr,i+1,len);
    }
    // function to swap the elements in a heap    
    public void swap(int [] harr,int a,int b)
    {
        int temp;
        temp=harr[a];
        harr[a]=harr[b];
        harr[b]=temp;
    }
    //build heap util function recursively
    public void buildHeapUtil(int [] harr,int k)        
    {
        if(k==0) return;
        if(harr[k]<harr[(k-1)/2])
        {
            swap(harr,k,(k-1)/2);
            buildHeapUtil(harr,(k-1)/2);
        }
    }  
    //function of heap sort
    public void heapSort(int [] harr) throws InterruptedException //throws InterruptedException       
    {
        int arrLen=harr.length+1;
        buildHeapRecur(harr,1,--arrLen);
        System.out.println("build heap of array is : ");
        for(int i=0;i<harr.length;i++)
        {  
            Thread.sleep(500);
            System.out.print(harr[i]+",");
        }
        System.out.println("\ndeleting first element and then heapify : ");
        for(int i=0;i<harr.length;i++)
        {  
          //  System.out.print(harr[0]+",");
            swap(harr,0,arrLen-1);
            heapyfiy(harr,0,--arrLen);
//            System.out.println(arrLen+" bbjh");
            for(int j=0;j<arrLen;j++)
            {  
              
                Thread.sleep(500);
                System.out.print(harr[j]+",");
            }
            if(arrLen>1)
            System.out.println("\ndeleting first ellement then heapify : "); 
            else if (arrLen==0)
            {
                System.out.println("\nafter completing the process of deletion and heapify");
                System.out.println("sorting order of element by heap sort is : ");
                for(int j=harr.length-1;j>=0;j--)
                {
                    Thread.sleep(500);
                    System.out.print(harr[j]+",");
                }
            }
        }
    }

    public void heapyfiy(int[] harr, int i, int arrLen) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(i>arrLen) return ;
        int index=i;
        if((2*i+1)<arrLen && (2*i+2)<arrLen)
        {
            if(harr[i]>(harr[2*i+1]<harr[2*i+2]?harr[2*i+1]:harr[2*i+2]))
            {
                index=(harr[2*i+1]<harr[2*i+2]?(2*i+1):(2*i+2));
                swap(harr,i,index);
            }
            else 
                return ;
        }
        else if((2*i+1)<arrLen)
        {
            if(harr[i]>harr[2*i+1])
            {
                index=(2*i+1);
                swap(harr,i,index);
            }
            else 
                return ;
        }
        else
            return ;
        heapyfiy(harr,index,arrLen);
    }
}
public class Heap {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException  {  //throws InterruptedException {
        // TODO code application logic here
        BuildHeap h=new BuildHeap();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int [] arr=new int[sc.nextInt()];
        System.out.println("enter "+arr.length+" numbers in an array");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
      h.heapSort(arr);   
        System.out.println();
    }   
}
