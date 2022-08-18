// BOJ 12899 ������ ���� segment tree
#include <iostream>
#define size (1 << 21)
using namespace std;

int list[size * 2];

void update(int index){
	while(index > 0){
		index /= 2;
		list[index] = list[index * 2] + list[index * 2 + 1];
	}
	return;
}

void calc(int index, int num){
	if(index > size){
		cout << index - size + 1 << "\n";
		return;
	} 
	// ���� �ڽİ��� �θ𺸴� ������ ���� ���� ���������� �̵� 
	if(list[index*2] < num){
		calc(index*2+1, num-list[index*2]);
	}
	// ���� �ڽİ��� �θ𺸴� ũ�ų� ������ �������� �̵�
	else{
		calc(index*2, num);
	}
}

int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for(int i=0; i<n; i++){
		int a, b;
		cin >> a >> b;
		if(a == 1){
			list[size + b-1] = 1;
			update(size + b-1);
		}
		if(a == 2){
			calc(1, b);
		}
	}
	
	return 0;
} 
