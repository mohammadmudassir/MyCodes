/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestringusingstack;

import java.util.Scanner;

/**
 *
 * @author Muzammil
 */
class Node
{
    char data;
    Node next;
    Node(char data)
    {
        this.data=data;
        next=null;
    }
}
public class ReverseStringUsingStack {

    /**
     * @param args the command line arguments
     */
    private Node head=null;
    private int top;
    private final int capacity;
    /** constructor */
    ReverseStringUsingStack(int capacity)
    {
        this.capacity=capacity;
        top=-1;
    }
    public boolean isEmpty()
    {
        if(top==-1)
        {
            return true;
        }
        else
            return false;
    }
    public boolean isFull()
    {
        if(top==capacity-1)
        {
            return true;
        }
        else
            return false;
    }
    public void push(char ch)
    {
        if(isFull())
        {
            System.out.println("Stack is overflow");
        }
        else
        {
             top++;
             Node newNode=new Node(ch);
             newNode.next=head;
             head=newNode; 
        }   
    }
    public char pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack is underflow");
            return 1;   
        }
        else
        {
            char k=head.data;
            head=head.next;
            top--;
            return k;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ReverseStringUsingStack stack=new ReverseStringUsingStack(100);
        Scanner sc=new Scanner(System.in);
        String str;
        System.out.println("enter the string :");
        str=sc.next();
        System.out.println("reverse string is :");
        System.out.println(stack.reverStrByStack(str));
        
    }

    public String reverStrByStack(String str) 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i=0;i<str.length();i++)
        {
             this.push(str.charAt(i));
        }
//        char [] arr=new char[str.length()];
        int k=str.length();
        str="";
        for(int i=0;i<k;i++)
        {
            str=str+this.pop();
        }
        return str;
        
    }
}
