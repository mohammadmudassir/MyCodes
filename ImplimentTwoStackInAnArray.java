/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implimenttwostackinanarray;

import java.util.Scanner;

/**
 *
 * @author Muzammil
 */
public class ImplimentTwoStackInAnArray {

    /**
     * @param args the command line arguments
     */
    private int top1;
    private int top2;
    private int [] arr;
    private int arrSize;
    ImplimentTwoStackInAnArray(int arrSize)
    {
        top1=-1;
        top2=arrSize;
        arr=new int[arrSize];
        this.arrSize=arrSize;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the siZe of ArraY");
        ImplimentTwoStackInAnArray twoStack=new ImplimentTwoStackInAnArray(sc.nextInt());
        twoStack.push1(10);
        twoStack.push2(20);
        System.out.println(twoStack.pop1());   
        System.out.println(twoStack.pop2());     
    }

    public void push1(int value) 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isFull())
        {
            System.out.println("Stack1 is overFlow");
            return;
        }
        else
        {
         //   top1++;
            arr[++top1]=value;
        }
    }
    public void push2(int value) 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isFull())
        {
            System.out.println("Stack2 is overFlow");
            return;
        }
        else
        {
        //    top2--;
            arr[--top2]=value;
        }
    }
    public boolean isFull() 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(top1+1==top2 || top2-1==top1)
        {
            return true;
        }
        else
            return false;
    }
    public boolean isEmpty1()
    {
        if(top1==-1)
        {
            System.out.println("Stack1 is underFlow");
            return true;
        }
        else
            return false;
    }
     public boolean isEmpty2()
    {
        if(top2==arrSize)
        {
            System.out.println("Stack2 is underFlow");
            return true;
        }
        else
            return false;
    }
    public int pop1() 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isEmpty1())
        {
            return -1;
        }
        else
        {
          return arr[top1--];  
        }
    }
    public int pop2() 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(isEmpty2())
        {
            return -1;
        }
        else
        {
          return arr[top2++];  
        }
    }
}
