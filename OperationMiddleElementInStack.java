/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationmiddleelementinstack;

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
public class OperationMiddleElementInStack {

    /**
     * @param args the command line arguments
     */
    Node head=null;
    Node midPtr=null;
    private int top;
    OperationMiddleElementInStack()
    {
        top=-1;
        //count=0;
    }
    
        
    public static void main(String[] args) {
        // TODO code application logic here
        OperationMiddleElementInStack  stack=new OperationMiddleElementInStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.pop();
        if(stack.top==-1)
        {
            System.out.println("Stack is underFlow");

        }
        else
        {
            System.out.println("Middle vlue in stack is "+stack.midPtr.data);        
        }
    }

    public void push(int value) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Node newNode=new Node(value);
        if(head==null)
        {
         top++;
            head=newNode;
            midPtr=newNode;   
        }
        else
        {
             top++;
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            if(top%2==0)
            {
                midPtr=midPtr.prev;
           }
        }
    }
    public int pop()
    {
        if(this.isEmpty())
        {
            return -1;
        }
        else
        {
            
            int temp=head.data;
            head=head.next;
             top--;
             if(top%2!=0)
             {
                 midPtr=midPtr.next;
             }
            return temp;
        }
    }
    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(top==-1)
        {
           return true; 
        }
        else
        {
            return false;
        }
   }
}
