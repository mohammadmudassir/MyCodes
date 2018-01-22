/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementqueueusingstack;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Muzammil
 */
public class ImplementQueueUsingStack extends Stack<Integer>{
    /**
     * @param args the command line arguments
     */
    Stack<Integer> stack;
    ImplementQueueUsingStack()
    {
        stack=new Stack<>();
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        ImplementQueueUsingStack queue=new ImplementQueueUsingStack();
        Scanner sc=new Scanner(System.in);
        boolean valid=true;
        while(valid)
        {
             System.out.println("1.enQueue\n2.deQueue\n3.exit");
             System.out.println("Enter your choice");
             switch(sc.nextInt())
             {
                 case 1:
                     System.out.println("enter the value");
                     queue.enQueue(sc.nextInt());
                     break;
                 case 2:
                     System.out.println(queue.deQueue()+" is the deQueue value from the queue");
                     break;
                 case 3:
                     System.exit(0);              
             }
        }
    }
    public void enQueue(int item)
    {
        if(this.isEmpty())
        {
//            System.out.println("hhhhh");
          stack.push(item);  
        }
        else
        {
            while(!this.isEmpty())
            {
                stack.push(this.pop());
            }
            stack.push(item);
        } 
    }
    public int deQueue() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(stack.isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        else
        {
            while(!stack.isEmpty())
            {
               this.push(stack.pop());
            }
            int k=this.pop();
            while(!this.isEmpty())
            {
               stack.push(this.pop());
            }
            return k;
        }
    }   
}
