/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeneratebinarynumbersusingqueue;
import java.util.Scanner;
/**
 *
 * @author Muzammil
 */
public class BinaryNumbers {
    private int front;
    private int rear;
    private final int capacity;
    private String [] arr;
    BinaryNumbers(int capacity)
    {
        this.capacity=capacity;
        arr=new String[this.capacity];
        front=-1;
        rear=-1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the limit to generate binary numbers");
        BinaryNumbers queue=new BinaryNumbers(sc.nextInt());
        System.out.println("Binary numbers are");
        queue.enQueue("1");
        for(int i=1;i<=queue.capacity;i++)
        {
            queue.enQueue(queue.frontQue()+"0");        //Complexity O(n)
            queue.enQueue(queue.frontQue()+"1");        //SpaceComplexity O(1)
            System.out.println(queue.deQueue());
        }
        /** Another method to generate N binary number using Queue*/
//        for(int i=1;i<=queue.capacity;i++)
//        {
//            String Str1=queue.deQueue();      //Complexity O(n)
//            System.out.println(Str1);         //SpaceComplexity O(n)
//            String Str2=Str1;
//            queue.enQueue(Str1+"0");
//            queue.enQueue(Str2+"1");
//        }
    }
     public void enQueue(String str) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isFull())
        {
//            System.out.println("Queue is overFlow");
        }
        else
        {
            this.rear=(this.rear+1)%this.capacity;
            this.arr[this.rear]=str;
            if(this.front==-1)
            {
                
                this.front=this.rear;
            }
        }
    }
    public boolean isFull() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if((this.rear+1)%this.capacity==this.front)
    {
        return true;
    }
    else
    {
        return false;
    }  
}
    public String frontQue()
    {
        if(this.isEmpty())
        {
            return "";
        }
        else
        {
            
            return this.arr[this.front];
        }
    }
    public String deQueue() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(this.isEmpty())
        {
            return "";
        }
        else
        {
            String tempStr=this.arr[this.front];
            if(this.front==this.rear)
            {
                this.front=-1;
                this.rear=-1;
            }
            else
            {
               this.front=(this.front+1)%this.capacity; 
            }
            return tempStr;
        }
    }
    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(this.front==-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
