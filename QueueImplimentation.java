/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueimplimentation;

import java.util.Scanner;

/**
 *
 * @author Muzammil
 */
    
public class QueueImplimentation {

    /**
     * @param args the command line arguments
     */
    private int front;
    private int rear;
    private final int capacity;
    private int [] arr;
    QueueImplimentation(int capacity)
    {
        this.capacity=capacity;
        arr=new int[this.capacity];
        front=-1;
        rear=-1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("enter the capacity of the queue :");
        Scanner sc=new Scanner(System.in);
        int deQData;
        QueueImplimentation queue=new QueueImplimentation(sc.nextInt());
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        for(int i=0;i<5;i++)
        {
            deQData=queue.deQueue();
            if(deQData==-1)
            {
                System.out.println("Queue is underFlow");
            }
            else
            {
                System.out.println("Out item Form the Queue is "+deQData);
            }  
        }   
    }

    public void enQueue(int value) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isFull())
        {
            System.out.println("Queue is overFlow");
        }
        else
        {
            this.rear=(this.rear+1)%this.capacity;
            this.arr[this.rear]=value;
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
    public int deQueue() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(this.isEmpty())
        {
            return -1;
        }
        else
        {
            int temp=this.arr[this.front];
            if(this.front==this.rear)
            {
                this.front=-1;
                this.rear=-1;
            }
            else
            {
               this.front=(this.front+1)%this.capacity; 
            }
            return temp;
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
