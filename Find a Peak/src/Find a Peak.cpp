//============================================================================
// Name        : Find.cpp
// Author      : Yankun
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int findPeak(int input[], int length) {

	int start = 0;
	int end = length -1;
	//cout<<end<<endl;
	int mid = 0;
	while (start + 1 < end)
	{
		mid = start + (end - start)/2;
//		cout<<"start"<<endl;
//		cout<<start<<endl;
//		cout<<"mid"<<endl;
//		cout<<mid<<endl;
//		cout<<"end"<<endl;
//		cout<<end<<endl;
		if (input[mid] > input[mid - 1] && input[mid] > input[mid + 1])
		{
			//cout<<input[mid]<<endl;
			return input[mid];
		}
		else if (input[mid] > input[mid - 1] && input[mid] < input[mid + 1])
		{
			start = mid;
		}
		else
		{
			end = mid;
		}

	}
	return input[start]>input[end]?input[start]:input[end];
}

int main() {
	int a[] = {1,2,3,4,5,6,7,6,7,4,3};
	int result = findPeak(a, 10);
	cout<<result<<endl;
	return 0;
}
