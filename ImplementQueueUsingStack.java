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
    Stack<Integer> stack=new Stack<>();
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
                     queue.enQueue(sc.nextInt(),queue);
                     break;
                 case 2:
                     System.out.println(queue.deQueue(queue)+" is the deQueue value from the queue");
                     break;
                 case 3:
                     System.exit(0);
                             
             }
        }
    }
    public void enQueue(int item,ImplementQueueUsingStack queue)
    {
        if(queue.isEmpty())
        {
//            System.out.println("hhhhh");
          stack.push(item);  
        }
        else
        {
            while(!queue.isEmpty())
            {
                stack.push(queue.pop());
            }
            stack.push(item);
        } 
    }
    public int deQueue(ImplementQueueUsingStack queue) {
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
               queue.push(stack.pop());
            }
            int k=queue.pop();
            while(!queue.isEmpty())
            {
               stack.push(queue.pop());
            }
            return k;
        }
    }   
}
