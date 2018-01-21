/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueimplimentationbylinkedlist;

/**
 *
 * @author Muzammil
 */
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        next=null;
    }
}
public class QueueImplimentationByLinkedList {

    /**
     * @param args the command line arguments
     */
    private Node front;
    private Node rear;
    QueueImplimentationByLinkedList()
    {
        front=null;
        rear=null;
    }
    public void enQueue(int data)
    {
        Node newNode=new Node(data);
       if(isEmpty())
       {   
           this.front=newNode;
           this.rear=newNode;
       }
       else
       {
           this.rear.next=newNode;
           this.rear=this.rear.next;
       }
    }
    public static void main(String[] args) {
        // TODO code application logic hereByLinkedList();
        QueueImplimentationByLinkedList queue=new QueueImplimentationByLinkedList();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        int deQueueValue;
        for(int i=0;i<6;i++)
        {
            deQueueValue=queue.deQueue();
            if(deQueueValue==-1)
            {
                System.out.println("Queue is Empty");
            }
            else
            {
                System.out.println(deQueueValue+" is the element out from the Queue");
            }
        }   
    }
    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(this.front==null)
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
        if(isEmpty())
        {
            return -1;
        }
        else
        {
            int k=this.front.data;
            if(this.front==this.rear)
            {
                this.front=null;
                this.rear=null;
            }
            else
            {
                this.front=this.front.next;
            }
            return k;
        }
    }   
}
