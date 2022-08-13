// BOJ 2517 �޸��� ���׸�ƮƮ��
#include <iostream>
#include <vector>
#include <algorithm>
#define size (1 << 19) // �� 16�� �ȵǰ� 19�� ��������? -> size ���� "\n" �� ������ 
using namespace std;

struct info{
	int value;
	int index;
};

bool compareValue(info a, info b){
	return a.value < b.value;
}

bool compareIndex(info a, info b){
	return a.index < b.index;
}

int tree[size * 2];

void update(int index){
	tree[index] = 1;
	while(index > 0){
		index /= 2;
		tree[index] = tree[index * 2] + tree[index * 2 + 1];
	}
}

int calc(int start, int end){
	int sum = 0;
	while(start <= end){
		if(start % 2 == 1) sum += tree[start++];
		if(end % 2 == 0) sum += tree[end--];
		start /= 2;
		end /= 2;
	}
	return sum;
}

int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	
//	vector <info> list; // vector ���� 
	info list[n];  // array ���� 
	for(int i=0; i<n; i++){
		int num;
		cin >> num;
		list[i] = {num, i}; //
//		list.push_back({num, i}); // 
	}
	
//	sort(list.begin(), list.end(), compareValue); // 
	sort(list, list+n, compareValue); //
	for(int i=0; i<n; i++) list[i].value = i;
	
//	sort(list.begin(), list.end(), compareIndex); // 
	sort(list, list+n, compareIndex); //
	
	for(int i=0; i<n; i++){
		update(list[i].value+size);
		cout << calc(list[i].value+size, n+size) << "\n";
	}
	
	return 0;
} 
