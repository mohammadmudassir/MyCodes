/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Muzammil
 */
class SudokuClass
{
    public int [] [] mtrx;
    public int row,coloumn;
    SudokuClass(int row,int coloumn)
    {
        Scanner sc=new Scanner(System.in);
        this.row=row;
        this.coloumn=coloumn;
        mtrx=new int[row][coloumn];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<coloumn;j++)
            {
                mtrx[i][j]=sc.nextInt();
            }
        }
            
    }
    void  solveSudokuPuzzle()
    {
         solveSudoku(mtrx,row,coloumn,0,0,1);
         for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(mtrx[i][j]+" ");
            }
            System.out.println();
        }
    }
    boolean solveSudoku(int [] [] mtrx,int row,int coloumn,int rowIndex,int coloumnIndex,int num)
    {
       if(rowIndex+1==row && coloumnIndex==coloumn)
           return true;
       if(coloumnIndex<coloumn)
       {
           if(mtrx[rowIndex][coloumnIndex]!=0)
           {
               boolean isTrue=solveSudoku(mtrx,row,coloumn,rowIndex,coloumnIndex+1,1);
               if(isTrue==true)
                   return true;
               else return false;
           }
           if(isSafeNumber(mtrx,row,coloumn,rowIndex,coloumnIndex,num)==true)
           {
               mtrx[rowIndex][coloumnIndex]=num;
               boolean isTrue=solveSudoku(mtrx,row,coloumn,rowIndex,coloumnIndex+1,1);
               if(isTrue==true)
                   return true;
               mtrx[rowIndex][coloumnIndex]=0;
           }
           if(num<4)
           {
               boolean isTrue=solveSudoku(mtrx,row,coloumn,rowIndex,coloumnIndex,num+1);
               if(isTrue==true)
                   return true;
           }
           mtrx[rowIndex][coloumnIndex]=0;
           return false;
       }
       else
       {
           boolean isTrue=solveSudoku(mtrx,row,coloumn,rowIndex+1,0,1);
           if(isTrue==true)
                   return true;
       }
       mtrx[rowIndex][coloumnIndex-1]=0;
               return false;      
    }

    private boolean isSafeNumber(int[][] mtrx, int row, int coloumn, int rowIndex, int coloumnIndex, int num) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean t1=true,t2=true,t3=true;
        for(int i=0;i<coloumn;i++)
        {
            if(mtrx[rowIndex][i]==num)
            {
                t1=false;
                break;
            }
        }
        for(int j=0;j<row;j++)
        {
            if(mtrx[j][coloumnIndex]==num)
            {
                t2=false;
                break;
            }
        }
        if(rowIndex>=0 && rowIndex<=1  && coloumnIndex>=0 && coloumnIndex <=1)
        {
            for(int i=0;i<=1;i++)
            {
                for(int j=0;j<=1;j++)
                {
                    if(mtrx[i][j]==num)
                    {
                        t3=false;
                        break;
                    }
                }      
            }
        }
        else if(rowIndex>=0 && rowIndex<=1  && coloumnIndex>=2 && coloumnIndex <=3)
        {
            for(int i=0;i<=1;i++)
            {
                for(int j=2;j<=3;j++)
                {
                    if(mtrx[i][j]==num)
                    {
                        t3=false;
                        break;
                    }
                }      
            }
        }
        else if(rowIndex>=2 && rowIndex<=3  && coloumnIndex>=0 && coloumnIndex <=1)
        {
            for(int i=2;i<=3;i++)
            {
                for(int j=0;j<=1;j++)
                {
                    if(mtrx[i][j]==num)
                    {
                        t3=false;
                        break;
                    }
                }      
            }
        }
        else
        {
            for(int i=2;i<=3;i++)
            {
                for(int j=2;j<=3;j++)
                {
                    if(mtrx[i][j]==num)
                    {
                        t3=false;
                        break;
                    }
                }      
            }
        }
        return t1 && t2 && t3;
    }
}
    
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("enter the sudoku 4X4 : ");
        Scanner sc=new Scanner(System.in);
        SudokuClass obj=new SudokuClass(4,4);
        obj.solveSudokuPuzzle();        
    }
}
