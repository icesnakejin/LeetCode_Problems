//============================================================================
// Name        : Triangle.cpp
// Author      : Yankun
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

int minimumTotal(vector<vector<int> > &triangle) {

	vector<vector<int> > sum;
	for(int i = 0; i < 4; i++)
		{
		    vector<int> row;
		    sum.push_back(row);
		}
	int n = triangle.size();
//			for (int i = 0 ;i < triangle.size();i++)
//			{
//				for (int j = 0 ; j <= i;j++)
//				{
//					cout<<triangle[i][j]<<endl;
//				}
//				cout<<'\n'<<endl;
//			}
//	cout<<n<<endl;
	//initialization
	for (int i = 0; i < n; i++)
	{
		sum[n-1].push_back(triangle[n-1][i]);
		//cout<<i<<endl;
	}

	for (int i = 0; i < n; i++)
		{
			//sum[n-1][i] = triangle[n-1][i];
			//cout<<sum[3][i]<<endl;
		}

	for (int i = n-2; i >= 0; i--)
	{
		//cout<<i<<endl;
		for (int j = 0;j<=i;j++)
		{
			//cout<<j<<endl;
			sum[i].push_back(min(sum[i+1][j],sum[i+1][j+1]) + triangle[i][j]);


		}
	}
	//cout<<sum[0][0]<<endl;
	return sum[0][0];
}

int main() {
	vector<vector<int> > sum;
	for(int i = 0; i < 4; i++)
	{
	    vector<int> row;
	    sum.push_back(row);
	}
	sum[0].push_back(-2);
	sum[1].push_back(-3);
	sum[1].push_back(4);
	sum[2].push_back(-6);
	sum[2].push_back(-5);
	sum[2].push_back(7);
	sum[3].push_back(-4);
	sum[3].push_back(-1);
	sum[3].push_back(-8);
	sum[3].push_back(3);

	int result =  minimumTotal(sum);
//	for (int i = 0 ;i < sum.size();i++)
//	{
//		for (int j = 0 ; j <= i;j++)
//		{
//			cout<<sum[i][j]<<endl;
//		}
//		cout<<'\n'<<endl;
//	}
	cout<<result<<endl;

	return 0;
}
