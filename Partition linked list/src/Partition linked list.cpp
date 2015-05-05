//============================================================================
// Name        : Partition.cpp
// Author      : Yankun
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

int findPartition(ListNode *head, int x) {
	while (head->next != NULL && x > 1)
	{
	//cout<<x<<endl;
		//cout<<head->val<<endl;
		head = head->next;
		x--;
	}

	return head->val;

}
ListNode *partition(ListNode *head, int x) {

	if (head == NULL)
	{
		return head;
	}
	ListNode* leftHead = new ListNode(0);
	ListNode* rightHead = new ListNode(0);
	ListNode* leftTail = new ListNode(0);;
	ListNode* rightTail = new ListNode(0);;

	leftHead->next = NULL;
	rightHead->next = NULL;

	while (head != NULL)
	{
		if (head->val < x)
		{
			//cout<<"left"<<endl;
			leftTail->next = head;
			if (leftHead->next == NULL)
			{
				leftHead->next = leftTail->next;
			}
			//cout<<leftTail->val<<endl;
			leftTail = leftTail->next;
		} else
		{
			rightTail->next = head;
			if (rightHead->next == NULL)
			{
				rightHead->next = rightTail->next;
			}
			rightTail = rightTail->next;
		}
		head = head->next;
	}
	rightTail->next = NULL;

	if (leftHead->next == NULL)
	{
		//cout<<"b"<<endl;
		return rightHead->next;
	}else if (rightHead->next == NULL)
	{
		return leftHead->next;
	}else
	{
		//cout<<"a"<<endl;
		//cout<<leftTail->val<<endl;
		leftTail->next = rightHead->next;
		//cout<<leftTail->val<<endl;
//		while (leftHead->next != NULL)
//				{
//					cout<<"l"<<endl;
//					cout<< leftHead->next->val<<endl;
//					leftHead->next = leftHead->next->next;
//				}
//		while (rightHead->next != NULL)
//						{
//							cout<<"r"<<endl;
//							cout<< rightHead->next->val<<endl;
//							rightHead->next = rightHead->next->next;
//						}
		return leftHead->next;
	}



 }


int main() {
	ListNode* head = new ListNode(2);
	ListNode* a = new ListNode(1);
	ListNode* b = new ListNode(3);
	ListNode* c = new ListNode(4);
	ListNode* d = new ListNode(2);
	ListNode* e = new ListNode(2);
	head->next = a;
    a->next = b;
	b->next = c;
	c->next = d;
	d->next = e;

	head = partition(head, 1);
	//cout<<head<<endl;
	while (head != NULL)
		{
			//cout<<"a"<<endl;
			cout<< head->val<<endl;
			head = head->next;
		}
	return 0;
}
