// boj 2749 �Ǻ���ġ ��3 G2
#include <cstdio>
#include <vector>
using namespace std;
// �ǻ�� �ֱ��� ����

int main(){
	unsigned long long num;
	scanf("%llu", &num);
	vector <int> list;
	
	list.push_back(0);
	list.push_back(1);	
	
	for(int i=2; i<1500000; i++){
		list.push_back((list[i-2]+list[i-1])%1000000);
	}
	printf("%d", list[num%1500000]);
	
	return 0;
} 
