// BOJ 2293 ���� 1 dp
#include <iostream>
using namespace std;

int list[101];
int dp[10001];
int n, k;
int ans = 0;

int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> k;
	// ��ġ�� ���� k�� �Ǵ� ����Ǽ� ���ϱ� 
	
	for(int i=1; i<=n; i++){
		cin >> list[i];
	}
	
	dp[0] = 1;
	for(int i=1; i<=n; i++){
		for(int j=list[i]; j<=k; j++){
			dp[j] = dp[j] + dp[j-list[i]];
		}
	}
	
	cout << dp[k];
	
	return 0;
} 
