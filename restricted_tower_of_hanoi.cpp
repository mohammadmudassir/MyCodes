#include<bits/stdc++.h>
#include <stack>
using namespace std;

int move_A_to_B(int& n,int& k1,int& k2,int& k3,int& k4,stack <int>& s1,stack <int>& s2,stack <int>& s3)
{

    if(s1.empty())  return false;
    int top_s1_item=s1.top();
    s1.pop();
    if(s2.empty())
    {

        cout<<"A to B"<<endl;
        s2.push(top_s1_item);
        k1=0;k2=1;k3=0;k4=1;
        n++;
         return 1;
    }
    else{

        int top_s2_item=s2.top();
        if(top_s1_item<top_s2_item)
        {
            cout<<"A to B"<<endl;
            s2.push(top_s1_item);
            k1=0;k2=1;k3=0;k4=1;
            n++;
             return 1;
        }
        else{
            s1.push(top_s1_item);
             return 0;
        }
    }
}
bool move_B_to_C(int& n,int& k1,int& k2,int& k3,int& k4,stack <int>& s1,stack <int>& s2,stack <int> &s3)
{

    if(s2.empty())  return false;
    int top_s2_item=s2.top();
    s2.pop();
    if(s3.empty())
    {

        cout<<"B to C\n";
        s3.push(top_s2_item);
        k1=1;k2=0;k3=1;k4=0;
        n++;
         return true;
    }
    else{

        int top_s3_item=s3.top();
        if(top_s2_item<top_s3_item)
        {
            cout<<"B to C\n";
            s3.push(top_s2_item);
            k1=1;k2=0;k3=1;k4=0;
            n++;
             return true;
        }
        else{
            s2.push(top_s2_item);
             return false;
        }
    }
}
bool move_B_to_A(int& n,int& k1,int& k2,int& k3,int& k4,stack <int>& s1,stack <int>& s2,stack <int>& s3)
{

    if(s2.empty())  return false;
    int top_s2_item=s2.top();
    s2.pop();
    if(s1.empty())
    {

        cout<<"B to A\n";
        s1.push(top_s2_item);
        k1=0;k2=1;k3=0;k4=1;
        n++;
         return true;
    }
    else{

        int top_s1_item=s1.top();
        if(top_s2_item<top_s1_item)
        {
            cout<<"B to A\n";
            s1.push(top_s2_item);
            k1=0;k2=1;k3=0;k4=1;
            n++;
             return true;
        }
        else{
            s2.push(top_s2_item);
             return false;
        }
    }
}
bool move_C_to_B(int& n,int& k1,int& k2,int& k3,int& k4,stack <int>& s1,stack <int>& s2,stack <int>& s3)
{

    if(s3.empty())  return false;
    int top_s3_item=s3.top();
    s3.pop();
    if(s2.empty())
    {

        cout<<"C to B\n";
        s2.push(top_s3_item);
        k1=1;k2=0;k3=1;k4=0;
        n++;
        return true;
    }
    else{

        int top_s2_item=s2.top();
        if(top_s3_item<top_s2_item)
        {
            cout<<"C to B\n";
            s2.push(top_s3_item);
            k1=1;k2=0;k3=1;k4=0;
            n++;
            return true;
        }
        else{
            s3.push(top_s3_item);
            return false;
        }
    }
}
int count_moves(int n,stack <int>& s1,stack <int>& s2,stack <int>& s3)
{
    int k1=1,k2=1,k3=1,k4=1;
    int moves=0;
    while(!s1.empty() || !s2.empty())
    {

        if(k1)
        {
            if(move_A_to_B(moves,k1,k2,k3,k4,s1,s2,s3))
            {

                continue;
            }
        }
        if(k2)
        {

            if(move_B_to_C(moves,k1,k2,k3,k4,s1,s2,s3))
            {
                continue;
            }
        }
        if(k3)
        {
            if(move_B_to_A(moves,k1,k2,k3,k4,s1,s2,s3))
            {
                continue;
            }
        }
        if(k4)
        {
            if(move_C_to_B(moves,k1,k2,k3,k4,s1,s2,s3))
            {
                continue;
            }
        }
    }
    return moves;
}

int  main()
{
    cout<<"enter the number of disk"<<endl;
    int num_disk;
    cin>>num_disk;
    int push_var=num_disk;
    stack <int> s1;
    stack <int> s2;
    stack <int> s3;
    while(push_var>0)
    {
        s1.push(push_var);
        push_var--;
    }
   cout<<"total moves are : "<<count_moves(num_disk,s1,s2,s3);
}
