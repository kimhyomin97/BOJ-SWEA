// BOJ 9095 1, 2, 3 ���ϱ� DP
#include <iostream>
using namespace std;

int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	for(int i=0; i<t; i++){
		int num;
		cin >> num;
		// 1 2 3 �� ������ num �� ��Ÿ���� ����� ���� ���
		int dp[num+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<=num; i++){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		cout << dp[num] << "\n";
	}
	return 0;
} 
