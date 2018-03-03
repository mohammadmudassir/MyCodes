#include<iostream>
#include<stack>
using namespace std;
struct Node
{
	int data;
	Node *left,*right;
};
class Tree
{
	private :
		Node* root;
	public :
		Tree(int data)
		{
			root=create_node(data);
		}
		Node* get_root_address()
		{
			return root;
		}
		Node* create_node(int data)
		{
			Node* new_node=new Node();
			new_node->data=data;
			new_node->left=NULL;
			new_node->right=NULL;
			return new_node;
		}
		void inorder_traversal(Node* tree)
		{
			if(tree!=NULL)
			{
				inorder_traversal(tree->left);
				cout<<tree->data<<",";
				inorder_traversal(tree->right);
			}
		}
		void preorder_traversal(Node* tree)
		{
			if(tree!=NULL)
			{
				cout<<tree->data<<",";
				inorder_traversal(tree->left);
				inorder_traversal(tree->right);
			}
		}
		void postorder_traversal(Node* tree)
		{
			if(tree!=NULL)
			{
				inorder_traversal(tree->left);
				inorder_traversal(tree->right);
				cout<<tree->data<<",";
			}
		}
		void spiral_order_traversal_antiClock()
		{
			stack<Node*> s1;
			stack<Node*> s2;
			s1.push(root);
			while(!s1.empty() || !s2.empty())
			{
				Node* itr;
				while(!s1.empty())
				{
					itr=s1.top();
					s1.pop();
					cout<<itr->data<<",";
					if(itr->right!=NULL)
					{
						s2.push(itr->right);
					}
					if(itr->left!=NULL)
					{
						s2.push(itr->left);
					}
				}
				while(!s2.empty())
				{
					itr=s2.top();
					s2.pop();
					cout<<itr->data<<",";
					if(itr->left!=NULL)
					{
						s1.push(itr->left);
					}
					if(itr->right!=NULL)
					{
						s1.push(itr->right);
					}
				}
			}
		}
		void spiral_order_traversal_clock()
		{
			stack<Node*> s1;
			stack<Node*> s2;
			s1.push(root);
			while(!s1.empty() || !s2.empty())
			{
				Node* itr;
				while(!s1.empty())
				{
					itr=s1.top();
					s1.pop();
					cout<<itr->data<<",";
					if(itr->left!=NULL)
					{
						s2.push(itr->left);
					}
					if(itr->right!=NULL)
					{
						s2.push(itr->right);
					}
				}
				while(!s2.empty())
				{
					itr=s2.top();
					s2.pop();
					cout<<itr->data<<",";
					if(itr->right!=NULL)
					{
						s1.push(itr->right);
					}
					if(itr->left!=NULL)
					{
						s1.push(itr->left);
					}
				}
			}
		}
};
int main()
{
	Tree obj(10);
	obj.get_root_address()->left=obj.create_node(20);
	obj.get_root_address()->right=obj.create_node(30);
	obj.get_root_address()->left->left=obj.create_node(40);
	obj.get_root_address()->left->right=obj.create_node(50);
	obj.get_root_address()->right->left=obj.create_node(60);
	obj.get_root_address()->right->right=obj.create_node(70);
	while(1)
	{
		cout<<"1.inorder traversal\n2.preorder traversal\n3.postorder traversal\n4.spiral order traversal(anti clock wise)\n";
		cout<<"5.spiral order traversal(clock wise)\n6.exit"<<endl;
		cout<<"enter your choice"<<endl;
		int choice;
		cin>>choice;
		switch(choice)
		{
			case 1 :
				cout<<"Inorder traversal is"<<endl;
				obj.inorder_traversal(obj.get_root_address());
				break;
			case 2 :
				cout<<"Preorder traversal is"<<endl;
				obj.preorder_traversal(obj.get_root_address());
				break;
			case 3 :
				cout<<"Postorder traversal is"<<endl;
				obj.postorder_traversal(obj.get_root_address());
				break;
			case 4 :
				cout<<"Spiralorder traversal in anticlock wise is"<<endl;
				obj.spiral_order_traversal_antiClock();
				break;
			case 5 :
				cout<<"Spiralorder traversal in clock wise is"<<endl;
				obj.spiral_order_traversal_clock();
				break;
			case 6 :
				exit(0);			
		}
		cout<<endl;
	}	
}
