//============================================================================
// Name        : remove.cpp
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


    ListNode *deleteDuplicates(ListNode *head) {
        if (head == NULL)
        {
            return head;
        }
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* node = dummy;
        while (node->next != NULL && node->next->next!=NULL)
        {
        	//cout<<node->next<<endl;

        	   if (node->next->val == node->next->next->val)
        	   {
        		  int val = node->next->val;
        		  while (node->next != NULL && node->next->val == val)
        		  {
        			  //cout<<dummy->next<<endl;
        			  node->next = node->next->next;
        		  }


        	   } else
           {
//        	   cout<<dummy->next<<endl;
//        	   cout<<head<<endl;
        	   node = node->next;
           }
        }
        return dummy->next;
    }


int main() {
	ListNode* head = new ListNode(1);
	ListNode* a = new ListNode(1);
	ListNode* b = new ListNode(3);
	head->next = a;
	a->next = b;

	head = deleteDuplicates(head);

	while (head != NULL)
	{
		//cout<<"a"<<endl;
		cout<< head->val<<endl;
		head = head->next;
	}
	return 0;
}
