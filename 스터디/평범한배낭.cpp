#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct info{
	int value;
	int weight;
};

bool operator < (info a, info b){
	return a.value < b.value;
}

int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k; // n : ��ǰ�� ����, k : ���� ���� 
	cin >> n >> k;
	
	vector<info> list;
	for(int i=0; i<n; i++){
		int w, v; // w : ������ ���� ,v : ������ ��ġ
		cin >> w >> v;
		list.push_back({v, w});
	} 
	sort(list.begin(), list.end()); // ������ ��ġ �������� ���� (��������)
	
	int dp[k][2]; // �������� ��ŭ�� ���̸� ���� dp�迭 [i][0] : ������ ����, [i][1] : ������ ��ġ 
	for(int i=0; i<k; i++) {
		dp[i][0] = 0;
		dp[i][1] = 0;
	}
	int answer = 0;
	
	for(int i=1; i<=k; i++){
		for(int j=0; j<n; j++){
			if(list[j].weight > i){
//				cout << dp[i][0] << " : a " << dp[i][1] << "\n";
//				dp[i][0] = dp[i-1][0];
//				dp[i][1] = dp[i-1][1];
//				cout << dp[i][0] << " : b " << dp[i][1] << "\n";
			}
			else{
				if(dp[i][1] < dp[i-list[j].weight][1] + list[j].value){
					dp[i][0] = dp[i-list[j].weight][0] + list[j].weight;
					dp[i][1] = dp[i-list[j].weight][1] + list[j].value;
					if(answer < dp[i][1]) answer = dp[i][1];
				}
				else{
					dp[i][0] = dp[i-1][0];
					dp[i][1] = dp[i-1][1];
				}
			}
		}
	}
	
	cout << answer << "\n";
//	for(int i=0; i<k; i++){
//		cout << dp[i][0] << " " << dp[i][1] << "\n";
//	}
	return 0;
}
