// https://school.programmers.co.kr/learn/courses/30/lessons/49994
// ���α׷��ӽ� �湮 ���� (��Ʈ����ũ, �ܼ�����) 
#include <string>
using namespace std;

int getReverse(int num){
    if(num == 1) return 3;
    if(num == 2) return 4;
    if(num == 3) return 1;
    if(num == 4) return 2;
}

int convert(char dir){
    if(dir=='U') return 1;
    if(dir=='R') return 2;
    if(dir=='D') return 3;
    if(dir=='L') return 4;
}

int solution(string dirs) {
    int answer = 0;
    int map[11][11];
    for(int i=0; i<11; i++){
        for(int j=0; j<11; j++){
            map[i][j] = 0;
        }
    }
    // 1 << 1 = ��, 1 << 2 = ��, 1 << 3 = ��, 1 << 4 = �� : ��Ʈ����ŷ���� ���
    int row = 5, col = 5;
    for(int i=0; i<dirs.length(); i++){
        char dir = dirs[i];
        int num = convert(dir);
        int now = map[row][col];
        if(num == 1 && (col+1 > 10)) continue;
        if(num == 2 && (row+1 > 10)) continue;
        if(num == 3 && (col-1 < 0)) continue;
        if(num == 4 && (row-1 < 0)) continue;
        if(now & (1 << num)){
            // �̹� �湮�� ��
            if(num == 1) col += 1;
            if(num == 2) row += 1;
            if(num == 3) col -= 1;
            if(num == 4) row -= 1;
        }
        else {
            // ó�� �ɾ ��
            answer++;
            // �ɾ�� �� ���
            map[row][col] += (1 << num);
            if(num == 1) col += 1;
            if(num == 2) row += 1;
            if(num == 3) col -= 1;
            if(num == 4) row -= 1;
            // �ɾ�� �� �ݴ���� ���
            int reverse = getReverse(num);
            map[row][col] += (1 << reverse);
        }
    }
    return answer;
}
