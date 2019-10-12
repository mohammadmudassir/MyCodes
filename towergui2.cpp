#include<bits/stdc++.h>
#include<graphics.h>
using namespace std;
int moves;
stack <int> peg[3];
void begins()
{
      cleardevice();

      stack <int> temp;

     ///    DISKS
     for(int j=0;j<3;j++)
     {
          while(!peg[j].empty())
          {
              temp.push(peg[j].top());
              peg[j].pop();
          }
          int i=0;
          while(!temp.empty())
          {
              if(temp.top()==1)
              {
                   rectangle(380+(250*j),370-i,440+(250*j),400-i);
                    setfillstyle(9,YELLOW);
                    floodfill(410+(250*j),385-i,WHITE);
                   i+=30;
              }
              else if(temp.top()==2)
              {
                   rectangle(360+(250*j),370-i,460+(250*j),400-i);
                   setfillstyle(9,RED);
                    floodfill(410+(250*j),385-i,WHITE);
                   i+=30;
              }
              else if(temp.top()==3)
              {
                   rectangle(330+(250*j),370-i,490+(250*j),400-i);
                   setfillstyle(9,BLUE);
                    floodfill(410+(250*j),385-i,WHITE);
                   i+=30;
              }
              else if(temp.top()==4)
              {
                   rectangle(300+(250*j),370-i,520+(250*j),400-i);
                   setfillstyle(9,GREEN);
                    floodfill(410+(250*j),385-i,WHITE);
                   i+=30;
              }
              else if(temp.top()==5)
              {
                   rectangle(290+(250*j),370-i,530+(250*j),400-i);
                   setfillstyle(9,CYAN);
                    floodfill(410+(250*j),385-i,WHITE);
                   i+=30;
              }
              peg[j].push(temp.top());
              temp.pop();
          }
     }
     ///     PEGS
        rectangle(405,200,415,400);
        setcolor(WHITE);
        settextstyle(ITALIC_FONTTYPE,HORIZ_DIR,100);
        outtextxy(405,410,"A");
        rectangle(655,200,665,400);
        setcolor(WHITE);
        settextstyle(ITALIC_FONTTYPE,HORIZ_DIR,100);
        outtextxy(655,410,"B");
        rectangle(905,200,915,400);
        setcolor(WHITE);
        settextstyle(ITALIC_FONTTYPE,HORIZ_DIR,100);
        outtextxy(905,410,"C");
        setfillstyle(1,WHITE);
        bar(250,400,1070,430);



}
void draw(int i,int j)
{
    moves++;
    i--;
    j--;
    peg[j].push(peg[i].top());
    peg[i].pop();
    delay(1000);        //time delay
 // getch();
    begins();
}

void solve(int num,int from, int aux,int to)
{
    if(num==1)
    {
        cout<<"MOVE DISK NO. "<<num<<" FROM "<<from<<" TO "<<aux<<endl;
        draw(from,aux);
        cout<<"MOVE DISK NO. "<<num<<" FROM "<<aux<<" TO "<<to<<endl;
        draw(aux,to);
        return;
    }
    solve(num-1,from,aux,to);
    cout<<"MOVE DISK NO. "<<num<<" FROM "<<from<<" TO "<<aux<<endl;
    draw(from,aux);
    solve(num-1,to,aux,from);
    cout<<"MOVE DISK NO. "<<num<<" FROM "<<aux<<" TO "<<to<<endl;
    draw(aux,to);
    solve(num-1,from,aux,to);
}

int main()
{
    cout<<"\tRESTRICTED  TOWER  OF  HANOI"<<endl;
    cout<<"==========================================\n"<<endl;
    int num;
    cout<<"ENTER THE NO. OF DISKS"<<endl;
    cin>>num;
    if(num>6)
        cout<<"ENTER VALID NO. OF DISKS"<<endl;
    else
    {
        moves=0;
        for(int i=num;i>0;i--)
            peg[0].push(i);

        int gd=0,gm;
        initgraph(&gd,&gm,"");
        begins();
        getch();
        solve(num,1,2,3);
        getch();
        closegraph();

    }
    cout<<"\n\n TOTAL NO. OF MOVES ARE =>  "<<moves<<endl<<endl;
    return 0;
}


/// WRITE A PROGRAM FOR PROCESS SCHEDULING WITH SHORTEST REMAINING TIME AND PRIORITY ALGO .  ALSO CALCULATE THE AVG WAITING TIME TURNAROUND TIME AND THROUGHPUT
