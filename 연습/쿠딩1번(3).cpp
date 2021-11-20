// ���� 1��
#include <cstdio>
#include <vector>
using namespace std;

int main(){
	int n;
	scanf("%d", &n);
	for(int i=0; i<n; i++){
		int mlist[5];
		int len=0;
		for(int m=0; m<5; m++){
			scanf("%d", &mlist[m]);
		}
		char str[100];
		while(1){
			char temp;
			scanf("%c", &temp);
			if(temp == '\n') break;
			str[len++] = temp;
		}
		int mcnt[5] = {0,};
		vector <int> mindex[5];
		for(int j=1; j<len; j++){
			if(str[j] == 'A'){
				mcnt[0]++;
				mindex[0].push_back(j-1);
				str[j] = '?';
			}
			if(str[j] == 'E'){
				mcnt[1]++;
				mindex[1].push_back(j-1);
				str[j] = '?';
			}
			if(str[j] == 'I'){
				mcnt[2]++;
				mindex[2].push_back(j-1);
				str[j] = '?';
			}
			if(str[j] == 'O'){
				mcnt[3]++;
				mindex[3].push_back(j-1);
				str[j] = '?';
			}
			if(str[j] == 'U'){
				mcnt[4]++;
				mindex[4].push_back(j-1);
				str[j] = '?';
			}	
		}
		
		int lenlist[5];
		for(int j=0; j<5; j++) lenlist[j] = mindex[j].size();
		for(int j=0; j<5; j++){
			if(mcnt[j] != 0){
				printf("%d%d",mlist[j], mcnt[j]);
				for(int k=0;k<lenlist[j];k++){
					printf("%d",mindex[j][k]);
				}
			}
		}
		for(int j=1; j<len; j++){
			printf("%d", str[j]);
		}
		printf("\n");
	}
	return 0;
}
