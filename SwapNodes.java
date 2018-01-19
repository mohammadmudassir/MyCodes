/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swapnodes;

import java.util.Scanner;

/**
 *
 * @author Muzammil
 */
class Node{
    int data;
    Node next;
    Node(int d)
    {
        data=d;
        next=null;
    }
}
public class SwapNodes {

    /**
     * @param args the command line arguments
     */
    Node head=null;
    
    public void push(int data)
    {
        Node newNode=new Node(data);
      if(head==null)
      {
          head=newNode;
      }
      else
      {
          Node temp=head;
          while(temp.next!=null)
          {
              temp=temp.next;
          }
          temp.next=newNode;
      }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    SwapNodes list=new SwapNodes();
    Scanner sc=new Scanner(System.in);
    int lenList,k;
        System.out.println("how many nodes do toy want to enter ??");
        lenList=sc.nextInt();
        System.out.println("enter "+lenList+" nodes values");
        for(int i=0;i<lenList;i++)
        {
            k=sc.nextInt();
            list.push(k);
        }
    int X,Y;
        System.out.println("which two nodes do you want to swap enter thos data ??");
        X=sc.nextInt();
        Y=sc.nextInt();
        list.swapNodesInList(X,Y); 
        list.printList();
    
    }

    public void swapNodesInList(int X, int Y) {
        if(X==Y)
            return;
        Node prevX=null,currX=head;
        Node prevY=null,currY=head;
        while(currX.data!=X)
        {
            prevX=currX;
            currX=currX.next;
        }
        while(currY.data!=Y)
        {
            prevY=currY;
            currY=currY.next;
        }
        if(prevX==null)
        {
            head=currY;
        }
        else
        {
            prevX.next=currY;
        }
        if(prevY==null)
        {
            head=currX;
        }
        else
        {
            prevY.next=currX;
        }
        Node temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;
    }

    public void printList() {
        while(head!=null)
        {
            System.out.print(head.data+",");
            head=head.next;
        }
    }
}
