#include <iostream>
#include <string>
using namespace std;
int solution(string s)
{
    int answer=0;

    int len = s.size();
    char left, right;
    for(int i=0; i<len; i++){
        int cnt = 0;
        for(int j=0; j<len-i; j++){ // right ���� left���� ���� ���� ����Ű�� �ʱ� ���� len-i ���� �ݺ�
            left = s[i+cnt]; // left ���� �յڰ� �Ȱ������� ��ĭ�� ���������� �̵�
            right = s[len-j-1]; // right ���� �׻� ��ĭ�� �������� �̵�
            if(left == right) cnt++;
            else{
                j-=cnt; // right���� �׻� ��ĭ�� �̵��ϱ� ������, ī���� ���� ������ �߰��� �� �ʱ�ȭ �ʿ� ex) abcbaa
                cnt = 0; // ���� �߽߰� ī���� �ʱ�ȭ, left���� �ٽ� ó����ġ���� ���� �� ����
            }
        }
        if(cnt){ // flag���� ����ص� ������, ���� for������ cnt�� �ʱ�ȭ���� �ʰ� ������������ �Ӹ���� ���̽�
            if(answer < cnt) answer = cnt;
        }
    }

    return answer;
}
