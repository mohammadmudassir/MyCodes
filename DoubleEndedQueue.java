/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubleendedqueueusingdoublylinkedlist;
import java.util.Scanner;
/**
 *
 * @author Muzammil
 */
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data=data;
        next=null;
        prev=null;
    }
}
public class DoubleEndedQueue {
    private Node front;
    private Node rear;
    DoubleEndedQueue()
    {
        front=null;
        rear=null;
    }
    /**
     * @param args the command line arguments
     */
    public boolean isEmpty()
    {
        if(front==null || rear==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        DoubleEndedQueue dQueue=new DoubleEndedQueue();
        Scanner sc=new Scanner(System.in);
        boolean valid=true;
        while(valid)
        {
            System.out.println("1.InsertionAtFrontEnd\n2.InsertionAtRearEnd\n3.DeletionAtFrontEnd\n4.DeletionAtRearEnd\n4.exit");
            System.out.println("Enter Your Choice");
            switch(sc.nextInt())
            {
                case 1:
                    System.out.println("Enter the value");
                    dQueue.insertAtFront(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter the value");
                    dQueue.insertAtRear(sc.nextInt());
                    break;
                case 3:
                    int deleteValueFr=dQueue.deleteAtFront();
                    if(deleteValueFr==-1)
                    {
                        System.out.println("Queue is Empty");
                    }
                    else
                    {
                        System.out.println(deleteValueFr);
                    }
                    break;
                case 4:
                    int deleteValueRe=dQueue.deleteAtRear();
                    if(deleteValueRe==-1)
                    {
                        System.out.println("Queue is Empty");
                    }
                    else
                    {
                        System.out.println(deleteValueRe);
                    }
                    break;
                case 5:
                    System.exit(0);
            }       
        }    
    }
    public void insertAtFront(int item) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Node newNode=new Node(item);
    if(this.isEmpty())
    {
        this.front=newNode;
        this.rear=newNode;
    }
    else
    {
        newNode.next=this.front;
        this.front.prev=newNode;
        this.front=newNode;
    }
  }
    public void insertAtRear(int item) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Node newNode=new Node(item);
        if(this.isEmpty())
        {
            this.front=newNode;
            this.rear=newNode;
        }
        else
        {
            this.rear.next=newNode;
            newNode.prev=this.rear;
            this.rear=newNode;
        }
    }
    public int deleteAtFront() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isEmpty())
        {
            return -1;
        }
        else
        {
            int k=this.front.data;
            this.front=this.front.next;
            if(this.front!=null)
            this.front.prev=null;
            return k;
        }
    }
    public int deleteAtRear() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if(isEmpty())
        {
            return -1;
        }
        else
        {
            int k=this.rear.data;
            this.rear=this.rear.prev;
            if(this.rear!=null)
            this.rear.next=null;
            return k;
        }
    }
}
