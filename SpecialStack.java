/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialstack;

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
class Stack
{
    private Node head=null;
    private int top;
    private int capacity;
    Stack(int capacity)
    {
        this.capacity=capacity;
        top=-1;
    }
    public void push(int value) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Node newNode=new Node(value);
        if(isFull())
        {
            System.out.println("Stack is overflow");
            System.exit(1);
        }
        else
        {
            newNode.next=head;
            top++;
            head=newNode;
        }   
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
    public int pop()
    {
        if(isEmpty())
        {
         //   System.out.println("Stack is underflow");
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

    public int peek() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return head.data;
    }
}
public class SpecialStack extends Stack {

    /**
     * @param args the command line arguments
     */
    Stack auxMin=new Stack(100);
    public static void main(String[] args) {
        // TODO code application logic here
        SpecialStack stack=new SpecialStack(100);
        stack.push(20);
        stack.push(30);
        stack.push(9);
        stack.push(5);
        stack.push(10);
        stack.push(1);
//        for(int i=0;i<=6;i++)
//        {
//            int checkValue1=stack.pop();
//            if(checkValue1==-1)
//            {
//                System.out.println("Stack is underFlow");
//            }
//            else
//            {
//                System.out.println("poped value is "+checkValue1);
//            }
//        }
        for(int i=0;i<=6;i++)
        {
            int checkValue2=stack.getMin();
            if(checkValue2==-1)
            {
                System.out.println("Stack is underFlow");
            }
            else
            {
                System.out.println("min value is "+checkValue2);
            }
        }
    }
    public SpecialStack(int capacity) {
        super(capacity);
    }
    @Override
    public void push(int value)
    {
        super.push(value);
        if(auxMin.isEmpty())
        {
          auxMin.push(value);  
        }
        else
        {
            if(value<auxMin.peek())
            {
               auxMin.push(value);
             //  System.out.println("push value in auxStack "+value);
            }
            else
            {
                auxMin.push(auxMin.peek());
            }
        }
    }
    @Override
    public int pop()
    {
        auxMin.pop();
        return super.pop();
    }
    public int getMin()
    {
        return auxMin.pop();
    }
}
