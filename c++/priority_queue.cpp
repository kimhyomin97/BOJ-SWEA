#include <iostream>
#include <queue>

using namespace std;

struct info {
	int cost;
	int distance;
};

bool operator < (info a, info b){
	if(a.cost == b.cost){
		return a.distance < b.distance; // cost���� ���� ��, distance�� ������������ ���� 
	} 
	return a.cost > b.cost; // cost�� ������������ ���� 
}

int main(){
	priority_queue<info> pq;
	
	pq.push({1, 1});
	pq.push({1, 2});
	pq.push({1, 3});
	pq.push({1, 4});
	pq.push({2, 2});
	pq.push({3, 3});
	
	while(!pq.empty()){
		info temp = pq.top();
		pq.pop();
		cout << "cost : " << temp.cost << " distance : " << temp.distance << "\n";
	}
	
	return 0;
}
