// boj 1753 �ִܰ��
// priority_queue ��� ��� 
#include <cstdio>
#include <vector>
#include <queue>
#include <memory.h>
#define INF 987654321
using namespace std;

struct info {
	int cost;
	int dest;
};

int v, e, k;
vector<info> map[20001];
int dij[20001] = {0,};
priority_queue <info> pq;

bool operator < (info a, info b){
	return a.cost > b.cost;
}

int main(){
	scanf("%d %d", &v, &e);
	scanf("%d", &k);
	for(int i=0; i<e; i++){
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		map[a].push_back({c, b});
	}
	
	for(int i=1; i<=v; i++) dij[i] = INF; // �ּҺ�� ������ �迭 ū������ �ʱ�ȭ 
	pq.push({0, k}); // {��� 0, ������ġ} ť�� �־��ش� 
	dij[k] = 0; // �ڱ��ڽ����� ���� ����� 0 
	
	while(pq.size()!=0){
		info now = pq.top(); // ���� ���� ��밪�� ��������� �����´� 
		pq.pop();
		if(dij[now.dest] < now.cost) continue; // ť�� �ִ� �ּҰ��� �̹� ���� �ּҰ����� ũ�ٸ� ��ŵ 
		for(int i=0; i<map[now.dest].size(); i++){
			// now�� ������ �ּҺ������ �� �� �ִ� ��忡�� �� �� �ִ� ������ ����� ����Ѵ�  
			info temp = map[now.dest][i];  
			if(dij[temp.dest] > dij[now.dest] + temp.cost){
				dij[temp.dest] = dij[now.dest] + temp.cost;
				pq.push({dij[temp.dest], temp.dest});
			}
		}
	}
	
	for(int i=1; i<=v; i++){
		if(dij[i] == INF) printf("INF\n");
		else printf("%d\n", dij[i]);
	}
	
	return 0;
} 
