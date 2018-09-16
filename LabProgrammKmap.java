/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprogrammkmap;

import java.util.Scanner;

/**
 *
 * @author hp
 */
class BooleanArray
{
    int first;
    int second; 
}
class MinimizeFunByKmap
{
    int num_of_term;
    int [] fun;
    int [][] Kmap;
    int [][] auxMtrx;
    BooleanArray [] rowBoolean;
    BooleanArray [] coloumnBoolean;
    public MinimizeFunByKmap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of term in your boolean function");
        num_of_term=sc.nextInt();
        fun=new int[num_of_term];
        for(int i=0;i<num_of_term;i++)
        {
            fun[i]=sc.nextInt();
        }
        rowBoolean=new BooleanArray[4];
        coloumnBoolean=new BooleanArray[4];
        for(int i=0;i<4;i++)
        {
            rowBoolean[i]=new BooleanArray();
            coloumnBoolean[i]=new BooleanArray();
        }
        
        rowBoolean[0].first=0;
        rowBoolean[0].second=0;
        rowBoolean[1].first=0;
        rowBoolean[1].second=1;
        rowBoolean[2].first=1;
        rowBoolean[2].second=1;
        rowBoolean[3].first=1;
        rowBoolean[3].second=0;
        
        coloumnBoolean[0].first=0;
        coloumnBoolean[0].second=0;
        coloumnBoolean[1].first=0;
        coloumnBoolean[1].second=1;
        coloumnBoolean[2].first=1;
        coloumnBoolean[2].second=1;
        coloumnBoolean[3].first=1;
        coloumnBoolean[3].second=0;
        
        
          Kmap=new int[4][4];
        //initializing aux mtrx
        auxMtrx=new int[4][4];
        auxMtrx[0][0]=0;
        auxMtrx[0][1]=1;
        auxMtrx[0][2]=3;
        auxMtrx[0][3]=2;
        auxMtrx[1][0]=4;
        auxMtrx[1][1]=5;
        auxMtrx[1][2]=7;
        auxMtrx[1][3]=6;
        auxMtrx[2][0]=12;
        auxMtrx[2][1]=13;
        auxMtrx[2][2]=15;
        auxMtrx[2][3]=14;
        auxMtrx[3][0]=8;
        auxMtrx[3][1]=9;
        auxMtrx[3][2]=11;
        auxMtrx[3][3]=10;
        for(int i=0;i<4;i++)
        {
            
        
            for(int j=0;j<4;j++)
                System.out.print(auxMtrx[i][j]+"  ");
            System.out.println();   
        }
    }
    public void createKmap()
    {
        for(int k=0;k<fun.length;k++)
        {
            int flag=0;
            for(int i=0;i<4;i++)
            {
                    for(int j=0;j<4;j++)
                    {
                        if(auxMtrx[i][j]==fun[k])
                        {
                            Kmap[i][j]=1;
                            flag=1;
                            break;
                        }
                    }
                        
                if(flag==1) break;
            }
        }
        for(int i=0;i<4;i++)
        {
            
        
            for(int j=0;j<4;j++)
                System.out.print(Kmap[i][j]+"  ");
            System.out.println();   
        }   
    }
    
    private void booleanEquationForRow(int i,int j)
    {
        if(rowBoolean[i].first==0 && rowBoolean[j].first==0)
        {

            System.out.print("A`"); 
        }
        else if(rowBoolean[i].first==1 && rowBoolean[j].first==1)
        {
            System.out.print("A"); 
        }

        if(rowBoolean[i].second==0 && rowBoolean[j].second==0)
        {

            System.out.print("B`"); 
        }
        else if(rowBoolean[i].second==1 && rowBoolean[j].second==1)
        {
            System.out.print("B"); 
        }
    }
    
    private void booleanEquationForColoumn(int i,int j)
    {
        if(coloumnBoolean[i].first==0 && coloumnBoolean[j].first==0)
        {

            System.out.print("C`"); 
        }
        else if(coloumnBoolean[i].first==1 && coloumnBoolean[j].first==1)
        {
            System.out.print("C"); 
        }

        if(coloumnBoolean[i].second==0 && coloumnBoolean[j].second==0)
        {

            System.out.print("D`"); 
        }
        else if(coloumnBoolean[i].second==1 && coloumnBoolean[j].second==1)
        {
            System.out.print("D"); 
        }
    }
    /* function to minimize the boolean Function using Kmap */
    void solveBooleanFunction() 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   /* it covers all the cases of eight pair row wise */     
        if(checkRowForOctPair(0,3)==true)
        {
            booleanEquationForRow(0,3);
            System.out.print("+"); 
        }
        for(int i=0;i<3;i++)
        {
            if(checkRowForOctPair(i,i+1)==true)
            {
                booleanEquationForRow(i,i+1);
                System.out.print("+"); 
            }
        }
        /* it covers all the cases of eight pair by coloumn wise */
        if(checkColoumnForOctPair(0,3)==true)
        {
            booleanEquationForColoumn(0,3);
            System.out.print("+");
        }
        for(int i=0;i<3;i++)
        {
            if(checkColoumnForOctPair(i,i+1)==true)
            {
                booleanEquationForColoumn(i,i+1);
                System.out.print("+"); 
            }
        }
        /* it covers four pair case row wise */ 
        for(int i=0;i<4;i++)
        {
            if(checkRowForQuadPair(i)==true)
            {
                giveBooleanFunctionForSingleRow(i);
               
                System.out.print("+"); 
            }
        }       
        /* it covers four pair case coloumn wise */ 
        for(int j=0;j<4;j++)
        {
            if(checkColoumnForQuadPair(j)==true)
            {
               giveBooleanFunctionForSingleColoumn(j);
                        System.out.print("+");
            }
        }
      /* its check a box of four 1's */  
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(Kmap[i][j]==1)
                {
                    /*increament and decreament row inde and coloumn index in rotating manner using modulo architecture */
                    int rowInc=(i+1)%4;
                    int rowDec=(i-1+4)%4;
                    int coloumnInc=(j+1)%4;
                    int coloumnDec=(j-1+4)%4;
                    /*check four 1's block clockwise down */
                    if(Kmap[i][j]==1 && (Kmap[i][coloumnInc]==1 || Kmap[i][coloumnInc]==-1) && (Kmap[rowInc][coloumnInc]==1 || Kmap[rowInc][coloumnInc]==-1) && (Kmap[rowInc][j]==1 || Kmap[rowInc][j]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[i][coloumnInc]=-1;
                        Kmap[rowInc][coloumnInc]=-1;
                        Kmap[rowInc][j]=-1;
                        booleanEquationForRow(i,rowInc);
                        booleanEquationForColoumn(j,coloumnInc);
                        System.out.print("+");  
                    }
                     /*check four 1's block anticlockwise down */
                    else if(Kmap[i][j]==1 && (Kmap[i][coloumnDec]==1 || Kmap[i][coloumnDec]==-1) && (Kmap[rowInc][coloumnDec]==1 || Kmap[rowInc][coloumnDec]==-1) && (Kmap[rowInc][j]==1 || Kmap[rowInc][j]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[i][coloumnDec]=-1;
                        Kmap[rowInc][coloumnDec]=-1;
                        Kmap[rowInc][j]=-1;
                        booleanEquationForRow(i,rowInc);
                        booleanEquationForColoumn(j,coloumnDec);
                        System.out.print("+");  
                    }
                     /*check four 1's block anticlockwise up */
                    else  if(Kmap[i][j]==1 && (Kmap[i][coloumnInc]==1 || Kmap[i][coloumnInc]==-1) && (Kmap[rowDec][coloumnInc]==1 || Kmap[rowDec][coloumnInc]==-1) && (Kmap[rowDec][j]==1 || Kmap[rowDec][j]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[i][coloumnInc]=-1;
                        Kmap[rowDec][coloumnInc]=-1;
                        Kmap[rowDec][j]=-1;
                        booleanEquationForRow(i,rowDec);
                        booleanEquationForColoumn(j,coloumnInc);
                        System.out.print("+");  
                    }
                     /*check four 1's block clockwise up */
                    /*it will cover four corner case also */
                    else  if(Kmap[i][j]==1 && (Kmap[i][coloumnDec]==1 || Kmap[i][coloumnDec]==-1) && (Kmap[rowDec][coloumnDec]==1 || Kmap[rowDec][coloumnDec]==-1) && (Kmap[rowDec][j]==1 || Kmap[rowDec][j]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[i][coloumnDec]=-1;
                        Kmap[rowDec][coloumnDec]=-1;
                        Kmap[rowDec][j]=-1;
                        booleanEquationForRow(i,rowDec);
                        booleanEquationForColoumn(j,coloumnDec);
                        System.out.print("+");  
                    }
                }
            }
        }
        /* its check of two 1's  pair for rows and coloumns*/  
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(Kmap[i][j]==1)
                {
                    /*increament and decreament row inde and coloumn index in rotating manner using modulo architecture */
                    int rowInc=(i+1)%4;
                    int rowDec=(i-1+4)%4;
                    int coloumnInc=(j+1)%4;
                    int coloumnDec=(j-1+4)%4;
                    /*check four 1's block clockwise down */
                    if(Kmap[i][j]==1 && (Kmap[i][coloumnInc]==1 || Kmap[i][coloumnInc]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[i][coloumnInc]=-1;
                        giveBooleanFunctionForSingleRow(i);
                        booleanEquationForColoumn(j,coloumnInc);
                        System.out.print("+");  
                    }
                     /*check four 1's block anticlockwise down */
                    else if(Kmap[i][j]==1 && (Kmap[i][coloumnDec]==1 || Kmap[i][coloumnDec]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[i][coloumnDec]=-1;
                        giveBooleanFunctionForSingleRow(i);
                        booleanEquationForColoumn(j,coloumnDec);
                        System.out.print("+");  
                    }
                     /*check four 1's block anticlockwise up */
                    else  if(Kmap[i][j]==1 && (Kmap[rowInc][j]==1 || Kmap[rowInc][j]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[rowInc][j]=-1;
                        booleanEquationForRow(i,rowInc);
                        giveBooleanFunctionForSingleColoumn(j);
                        System.out.print("+");  
                    }
                     /*check four 1's block clockwise up */
                    /*it will cover four corner case also */
                    else  if(Kmap[i][j]==1 && (Kmap[rowDec][j]==1 || Kmap[rowDec][j]==-1))
                    {
                        Kmap[i][j]=-1;
                        Kmap[rowDec][j]=-1;
                        booleanEquationForRow(i,rowDec);
                         giveBooleanFunctionForSingleColoumn(j);
                        System.out.print("+");  
                    }
                }
            }
        }
        
       /*it covers remaining single one's */
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(Kmap[i][j]==1)
                {
                    Kmap[i][j]=-1;
                    giveBooleanFunctionForSingleRow(i);
                    giveBooleanFunctionForSingleColoumn(j);
                    System.out.print("+");
                }
            }
        }
    }
     private boolean checkRowForQuadPair(int i1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int j=0;j<4;j++)
        {
            if(Kmap[i1][j]==0 || Kmap[i1][j]==-1)
                return false;
        }
        for(int j=0;j<4;j++)
        {
            Kmap[i1][j]=-1;
        }
        return true;
    }

      private boolean checkColoumnForQuadPair(int j1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i=0;i<4;i++)
        {
            if(Kmap[i][j1]==0 || Kmap[i][j1]==-1)
                return false;
        }
        for(int i=0;i<4;i++)
        {
            Kmap[i][j1]=-1;
        }
        return true; 
    }
    private boolean checkRowForOctPair(int i1, int i2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int j=0;j<4;j++)
        {
            if(Kmap[i1][j]==0 || Kmap[i1][j]==-1)
                return false;
        }
        for(int j=0;j<4;j++)
        {
            if(Kmap[i2][j]==0 || Kmap[i2][j]==-1)
                return false;
        }
        
        for(int j=0;j<4;j++)
        {
            Kmap[i1][j]=-1;
        }
        for(int j=0;j<4;j++)
        {
            Kmap[i2][j]=-1;
        }
        
        return true;
        
    }
    
    private boolean checkColoumnForOctPair(int j1, int j2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i=0;i<4;i++)
        {
            if(Kmap[i][j1]==0 || Kmap[i][j1]==-1)
                return false;
        }
        for(int i=0;i<4;i++)
        {
            if(Kmap[i][j2]==0 || Kmap[i][j2]==-1)
                return false;
        }
        for(int i=0;i<4;i++)
        {
            Kmap[i][j1]=-1;
        }
        for(int i=0;i<4;i++)
        {
            Kmap[i][j2]=-1;
        } 
        return true; 
    }
    /*it gives boolean function for single row */
    private void giveBooleanFunctionForSingleRow(int i) 
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(rowBoolean[i].first==0 && rowBoolean[i].second==0)
        {
            System.out.print("A`");
            System.out.print("B`");
        }
        else if(rowBoolean[i].first==1 && rowBoolean[i].second==1)
        {
            System.out.print("A");
            System.out.print("B");
        }
        else if(rowBoolean[i].first==0 && rowBoolean[i].second==1)
        {
            System.out.print("A`");
            System.out.print("B");
        }
        else if(rowBoolean[i].first==1 && rowBoolean[i].second==0)
        {
            System.out.print("A");
            System.out.print("B`");
        }
    }
    /* it gives boolean function for single coloumn */
    private void giveBooleanFunctionForSingleColoumn(int j)
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(coloumnBoolean[j].first==0 && coloumnBoolean[j].second==0)
        {
            System.out.print("C`");
            System.out.print("D`");
        }
        else if(coloumnBoolean[j].first==1 && coloumnBoolean[j].second==1)
        {
            System.out.print("C");
            System.out.print("D");
        }
        else if(coloumnBoolean[j].first==0 && coloumnBoolean[j].second==1)
        {
            System.out.print("C`");
            System.out.print("D");
        }
        else if(coloumnBoolean[j].first==1 && coloumnBoolean[j].second==0)
        {
            System.out.print("C");
            System.out.print("D`");
        }
    }   
}
public class LabProgrammKmap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        MinimizeFunByKmap obj=new MinimizeFunByKmap();
        System.out.println("this is a K-map");
        obj.createKmap();
        obj.solveBooleanFunction();
        
    }   
}