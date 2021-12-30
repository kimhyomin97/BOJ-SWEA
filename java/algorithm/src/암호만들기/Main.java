package ��ȣ�����;
import java.io.*;
import java.util.*;

public class Main {
	private static int L, C;
	private static char[] arr;
	private static char[] ans; // ���⿡ ���� �������̴�.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = new char[L];
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			String str = st.nextToken();
			arr[i] = str.charAt(0);
		}
		Arrays.sort(arr);
		// ��������� �Է�?
		
		// ���� - ����Ž�� -> �ϳ��� ������ �Ẽ�Ŵ�??
		recur(0,0);
		
	}
	public static void recur(int where, int from) {
		// where : ��� ���� ������??
		// from���� ���ڴٴ� ��?
		
		// final condition
		if(where == L) {
//			String str = new String(ans);
//			System.out.println(ans);
			if(check()) {
				System.out.println(new String(ans));	
			}
			return;
		}
		for(int i=from; i<C; i++) {
			ans[where] = arr[i];
			recur(where + 1, i+1);
		}
	}
	
	public static boolean check() {
		int countMoeum = 0, countJaeum = 0;
		boolean[] isMoeum = new boolean[128]; // �ƽ�Ű�ڵ� 128�� �迭
		// �ƽ�Ű�ڵ� ���ĺ��� �ص� �ȴ�
		isMoeum['a'] = true;
		isMoeum['e'] = true;
		isMoeum['i'] = true;
		isMoeum['o'] = true;
		isMoeum['u'] = true;
		
		for(int i=0;i<L;i++) { // �ܾ��� ���� == L
//			if(ans[i] == 'a' || ans[i] == 'o')
			if(isMoeum[ans[i]]) countMoeum++;
			else countJaeum++;
		}
//		if(countMoeum >= 1 && countJaeum >= 2) return true;
//		else return false; // �Ƚ��൵ �ȴ�
		return countMoeum >= 1 && countJaeum >= 2;
	}
}



