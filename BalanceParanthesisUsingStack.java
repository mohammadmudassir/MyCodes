/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceparanthesisusingstack;

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
public class BalanceParanthesisUsingStack {

    /**
     * @param args the command line arguments
     */
    private Node head=null;
    private int top;
    private final int capacity;
    /** constructor */
    BalanceParanthesisUsingStack(int capacity)
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
        char [] exp=new char[100];
        Scanner sc=new Scanner(System.in);
        BalanceParanthesisUsingStack stack=new BalanceParanthesisUsingStack(100);
        System.out.println("enter the expression");
        if(stack.checkParanthesis(sc.next()))
        {
            System.out.println("expression is balanced");
        }
        else
        {
        //    System.out.println("hello");
            System.out.println("expression is not balanced");
        }
    }

    public boolean checkParanthesis(String str) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    for(int i=0;i<str.length();i++)
    {
        if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[')
        {
            this.push(str.charAt(i));
        }
        else if(str.charAt(i)==')' || str.charAt(i)=='}' || str.charAt(i)==']')
        {
            if (this.isEmpty())
            {
                return false;
            }
            if (str.charAt(i)==')')
            {
             //   System.out.println(this.peek());
                if(this.peek()=='(')
                {
                   this.pop();
                   
                }
                else
                {
                    return false;
                }
            }
            else if(str.charAt(i)=='}')
            {
                
                if(this.peek()=='{')
                {
                   this.pop();
                }
                else
                {
                    return false;
                }
            }
            else 
            {
                
                if(this.peek()=='[')
                {
                   this.pop();
                }
                else
                {
                    return false;
                }
            }
        }
//        else
//            continue;
    }
        if(this.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }

    public char peek() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        
            return head.data;
//        
    }   
}
