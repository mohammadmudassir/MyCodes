/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcycle;
import java.util.*;
/**
 *
 * @author HP
 */
class Graph
{
    private int vertex;
    private int edges;
    int [][] mtrx;
    Graph(int vertex,int edges)
    {
        this.vertex=vertex;
        this.edges=edges;
        mtrx=new int[vertex][vertex];
    }
    public void createGraph()
    {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<this.edges;i++)
        {
           System.out.println("Enter "+(i+1)+" edge : ");
            this.mtrx[sc.nextInt()-1][sc.nextInt()-1]=1;  
        }  
    }
    public void displayGraph()
    {
        for(int i=0;i<this.vertex;i++)
        {
            
        
            for(int j=0;j<this.vertex;j++)
            {
                System.out.print(this.mtrx[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public void detectAllCyclesInGraph() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("ALL cycles in a graph are : ");
         int [] prm=new int[this.vertex];
        for(int i=0;i<this.vertex;i++)
        {
            int [] visited=new int[this.vertex];
            prm[i]=1;
          //  int [] countArrLen=new int[1];
              int len=1;
            int [] cycle=new int[this.vertex];
            cycle[0]=i;
            detectAllCyclesInGraphUtil(this.mtrx,i,i,visited,prm,len,cycle);
//            for(int j=0;j<this.vertex;j++)
//            {
//                visited[j]=0;
//            }


        } 
    }

    private void detectAllCyclesInGraphUtil(int[][] mtrx, int ri, int start_index, int[] visited, int[] prm,int len,int [] cycle) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int j=0;j<this.vertex;j++)
        {
            if(mtrx[ri][j]==1)
            {
                if(j==start_index)
                {
                   // System.out.println("cycle is detected after "+(ri+1));
                    for(int k=0;k<len;k++)
                    {
                        System.out.print((cycle[k]+1)+"-->");
                    }
                    System.out.println((start_index+1));
                }
                else if((prm[j]==1) || (visited[j]==1))
                {
                    
                    continue;
                    
                }
                else
                {
                    visited[j]=1;           //make node as visited
                    cycle[len]=j;
                    detectAllCyclesInGraphUtil(mtrx,j,start_index,visited,prm,len+1,cycle);  
                    visited[j]=0;       //Backtracking(make node unvisited)
                }
            }
            
        }
    }
}
public class GraphCycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter the number of vertex and edges (first vertex then edes)");
        Graph graph=new Graph(sc.nextInt(),sc.nextInt());
        graph.createGraph();
        graph.displayGraph();
        graph.detectAllCyclesInGraph();
    }
    
}




/*

8 12


1 8
1 2
2 3
3 4
4 2
4 5
5 6
6 1
6 3
6 7
7 1
8 2





*/