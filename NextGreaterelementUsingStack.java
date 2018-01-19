/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgreaterelementusingstack;

import java.util.Scanner;

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
public class NextGreaterElementUsingStack {

    /**
     * @param args the command line arguments
     */
    private Node head=null;
    private int top;
    private int capacity;
    NextGreaterElementUsingStack(int Capacity)
    {
        this.capacity=capacity;
        top=-1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        NextGreaterElementUsingStack stack=new NextGreaterElementUsingStack(100);
        Scanner sc=new Scanner(System.in);
        System.out.println("how many numbers do you want to enter :");
        int arrLen=sc.nextInt();
        int [] arr=new int[arrLen];
        System.out.println("enter "+arrLen+" numbers :");
        for(int i=0;i<arrLen;i++)
        {
            arr[i]=sc.nextInt();
        }
        stack.NGEfun(arr,arrLen);   
    }
    public void NGEfun(int[] arr,int arrLen) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i=0;i<arrLen;i++)
        {
            if(this.isEmpty())
            {
                this.push(arr[i]);
            }
            else if(arr[i]<this.peek())
            {
                this.push(arr[i]);
            }
            else
            {
                while(!this.isEmpty() && arr[i]>this.peek())
                {
                    System.out.println(arr[i]+" is the next greater element for "+this.pop());
                }
                this.push(arr[i]);
            }       
        }
        if(!this.isEmpty())
        {
            while(!this.isEmpty())
            {
              System.out.println("-1 is greatear elements for "+this.pop());
            }
        }
    }
    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(top==-1)
        {
            return true;
        }
        else
            return false;
    }
    public void push(int value) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Node newNode=new Node(value);
        newNode.next=head;
        top++;
        head=newNode;
    }
    public int peek()
    {
        if(isEmpty())
        {
            return 1000;
        }
        else
        return head.data;
    }
    public int pop() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isEmpty())
        {
            return -1;
        }
        else
        {
            int k=head.data;
            head=head.next;
            top--;
            return k;
        }
    }   
}
