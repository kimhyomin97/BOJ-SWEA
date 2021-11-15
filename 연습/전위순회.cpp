#include <cstdio>

int arr[8] = {0,1,2,3,4,5,6,7};
bool visit[8] = {false,};
int n = 8;

void dfs1(int num){
	if(num >= n) return;
	visit[num] = true;
	printf("%d ", arr[num]);
	if(visit[num*2] == false) dfs1(num*2);
	if(visit[num*2+1] == false) dfs1(num*2+1);
}

void dfs2(int num){
	if(num >= n) return;
	visit[num] = true;
	if(visit[num*2] == false) dfs2(num*2);
	printf("%d ", arr[num]);
	if(visit[num*2+1] == false) dfs2(num*2+1);
}

void dfs3(int num){
	if(num >= n) return;
	visit[num] = true;
	if(visit[num*2] == false) dfs3(num*2);
	if(visit[num*2+1] == false) dfs3(num*2+1);
	printf("%d ", arr[num]);
}

int main(){
	for(int i=1; i<n; i++) printf("%d ", arr[i]);
	printf("\n");
	printf("���� ��°�� : ");
	dfs1(1);
	for(int i=0; i<n; i++) visit[i]=false;
	printf("\n���� ��°�� : ");
	dfs2(1);
	for(int i=0; i<n; i++) visit[i]=false;
	printf("\n���� ��°�� : ");
	dfs3(1);
	
	return 0;
}
