// BOJ 12865 ����� �賶 DP
#include <iostream>
#include <algorithm>
using namespace std;

struct info{
	int weight;
	int value;
};

int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, k;
	cin >> n >> k;
	
	info list[n];
	for(int i=0; i<n; i++){
		cin >> list[i].weight >> list[i].value;
	}
	
	int dp[k+1] = {0};
	
	for(int i=0; i<n; i++){
		for(int j=k; j>0; j--){ 
		// �̺κ� 0���� �����ϸ� ���� �ߺ��Ǵ� ���� �߻� -> �ڿ������� ���� ������� �ذ� 
			if(j - list[i].weight < 0) continue;
			dp[j] = max(dp[j], dp[j-list[i].weight] + list[i].value);
		}
	}
	
	cout << dp[k];
	
	return 0;
} 
