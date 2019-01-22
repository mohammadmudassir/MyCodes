/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author HP
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     //   int len = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String [] strs = line.trim().split("\\s+");
        
        int [] arr = new int[strs.length];
        for(int i=0; i<strs.length ;i++)
        {
            arr[i]=Integer.parseInt(strs[i]);
        }
        for(int i=0; i<arr.length ;i++)
        {
            System.out.println(arr[i]+"-->"+i);
        }
      //  System.out.println();
        // TODO code application logic here
        int k = Integer.parseInt(br.readLine());
        System.out.println(binarySearch(arr,arr.length-1,k));
        findFrequency(arr , arr.length-1 , k);
        System.out.println("index is : "+findMidIfNotPresentkey(arr , arr.length , k));
    }
    private static int binarySearch(int [] arr , int last , int k)
    {
        int left=0 ;
        int right=last ;
            while(left<=right)
            {
                int mid = (left+right)/2;
                if(arr[mid]==k) 
                    return mid;
                else if(arr[mid] > k) 
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }
            }
            return -1;
    }
    private static void  findFrequency(int [] arr , int last , int k)
    {
        int lastIndex=findLast(arr , last , k);
        int startIndex=findStart(arr , last , k);
        System.out.println("last index is : "+lastIndex);
        System.out.println("start index is : "+startIndex);
        
    }
    private static int findLast(int [] arr , int last , int k)
    {
        int left = 0;
        int right = last ;
            while(left<=right)
            {
                int mid = (left+right)/2;
             //   if((mid==left || arr[mid]==k) && arr[mid]<arr[mid+1])
                if(arr[mid]==k && (k<arr[mid+1] || mid==last))
                {
                    return mid;
                }
                else if(arr[mid]>k)
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }   
            }
            return -1;
    }
    private static int findStart(int [] arr , int last , int k)
    {
        int left = 0;
        int right = last;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(arr[mid]==k && (k>arr[mid-1] || mid-1==0)) 
            {
                return mid;
            }
            else if(arr[mid]<k)
            {
                left = mid+1;
            }
            else 
                right = mid-1;
        }
        return -1;
    }
    private static int findMidIfNotPresentkey(int [] arr , int last , int k)
    {
        int left = 0;
        int right = last;
        int mid=0;
        while(left<=right)
        {
             mid = (left+right)/2;
            if(arr[mid]>k)
            {
                right = mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        while(arr[mid]>k)
        mid--;
        return mid+1;
    }
    
}
