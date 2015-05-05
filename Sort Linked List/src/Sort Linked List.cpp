//============================================================================
// Name        : Sort.cpp
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

ListNode* findMid(ListNode* head)
{
	ListNode* fast = head;
	ListNode* slow = head;
	while (fast->next != NULL && fast->next->next != NULL)
	{
		slow = slow->next;
		fast = fast->next->next;
	}
	return slow;
}

ListNode* merge (ListNode* head, ListNode* mid)
{
	ListNode* dummy = new ListNode(0);
	ListNode* newHead = new ListNode(0);
	newHead = dummy;
	while (head != NULL || mid != NULL)
	{
		if (head == NULL)
		{
			dummy->next = mid;
			mid = mid->next;
		}else if (mid == NULL)
		{
			dummy->next = head;
			head = head->next;
		}
		else
		{
			if (mid->val < head->val)
			{
				dummy->next = mid;
				mid = mid->next;
			} else
			{
				dummy->next = head;
				head = head->next;
			}
		}
		dummy = dummy->next;

	}
	return newHead->next;
}

ListNode *sortList(ListNode *head) {

if (head == NULL || head->next == NULL) {
	    return head;
	}
   //cout<<"head"<<endl;
   //cout<<head->val<<endl;
   ListNode* mid = findMid(head);
   //cout<<"mid"<<endl;
   //cout<<mid->val<<endl;
   ListNode* end = sortList(mid->next);
   mid->next = NULL;
   ListNode* start = sortList(head);

   ListNode* result = merge (start,end);
   //cout<<"result"<<endl;
   //cout<<result->val<<endl;
   return result;
}

int main() {
		ListNode* head = new ListNode(1);
		ListNode* a = new ListNode(2);
		ListNode* b = new ListNode(7);
		ListNode* c = new ListNode(4);
		ListNode* d = new ListNode(6);
		ListNode* e = new ListNode(8);
		ListNode* f = NULL;
		//head->next = a;
	    a->next = b;
		b->next = c;
		c->next = d;
		d->next = e;
		ListNode* result = sortList(head);
		//cout<<result->val<<endl;

		while (result != NULL)
				{
					//cout<<"a"<<endl;
					cout<< result->val<<endl;
					result = result->next;
				}
	return 0;
}
