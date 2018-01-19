/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackinfixtopostfix;

import java.util.Scanner;

/**
 *
 * @author Muzammil
 */
class Node
{
    char ch;
    Node next;
    Node(char ch)
    {
        this.ch=ch;
        next=null;
    }
}
public class StackInfixToPostFix {

    /**
     * @param args the command line arguments
     */
    Node head=null;
    int top;
    int capacity;
    StackInfixToPostFix(int capacity)
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
            char k=head.ch;
            head=head.next;
            top--;
            return k;
        }
        
    }
    public char peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is underflow");
            return 1;    
        }
        else
        {
            return head.ch;
        }
    }
    public int presidenceNum(char charAt) 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            switch(charAt)
            {
                case '+' : return 1;
                case '-' : return 1;
                case '*' : return 2;
                case '/' : return 2;
                case '$' : return 3;
                default :  return 0;
            }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    //    System.out.println("enter the capacity of Stack");
        Scanner sc=new Scanner(System.in);
        
    //    int cap=sc.nextInt();
        String exp;
        StackInfixToPostFix stack =new StackInfixToPostFix(100);
        System.out.println("enter the expression :");
        exp=sc.next();
        System.out.println(exp.length());
    //    System.out.println(arr);
         char [] arr=new char[exp.length()];
        // char [] expr=new char[exp.length()];
        int j=0;
         for(int i=0;i<exp.length();i++)
         {
             if(exp.charAt(i)>='A' && exp.charAt(i)<='Z' || exp.charAt(i)>='a' && exp.charAt(i)<='z' )
             {
                 arr[j++]=exp.charAt(i);
               //  System.out.println(arr[j-1]);
             }
             else if(exp.charAt(i)=='(' || exp.charAt(i)=='{' ||exp.charAt(i)=='[')
             {
                 stack.push(exp.charAt(i));
             }
             else if(exp.charAt(i)==')' || exp.charAt(i)=='}' ||exp.charAt(i)==']')
             {
                 while( stack.peek()!='(')
                 {
                     arr[j++]=stack.pop();
                 //    System.out.println(arr[j-1]);
                  //   System.out.println("hello");
                 }
                 stack.pop();         
             }
             else if(exp.charAt(i)=='+' || exp.charAt(i)=='-' ||exp.charAt(i)=='*' || exp.charAt(i)=='/' || exp.charAt(i)=='$')
             {
                 int exprk=stack.presidenceNum(exp.charAt(i));
             //    int stackk=stack.presidenceNum(stack.peek());
                 if(stack.isEmpty())
                 {
                      stack.push(exp.charAt(i));
                 }    
                else if(exprk>stack.presidenceNum(stack.peek()))
                 {
                //  System.out.println(exp.charAt(i));
                     stack.push(exp.charAt(i));
                     
                 }
                 else
                 {
                     while(exprk<=stack.presidenceNum(stack.peek()))
                     {
                         arr[j++]=stack.pop();
                         System.out.println(arr[j-1]);
                         if(stack.isEmpty())
                         {
                             stack.push(exp.charAt(i));
                             break;
                         }      
                     }
                     if(exprk>stack.presidenceNum(stack.peek()))
                     {
                         stack.push(exp.charAt(i));
                     }   
                 }      
              }
         }
         
         if(stack.isEmpty())
         {
             arr[j]='\0';
             
         }
         else
         {
             while(!stack.isEmpty())
             {
                 
                 arr[j++]=stack.pop();
            //    System.out.println(arr[j-1]);
             }
             
           //  arr[j]='\0';
         }
       //  System.out.println("hello");
         System.out.println(arr);
         
    }
}
