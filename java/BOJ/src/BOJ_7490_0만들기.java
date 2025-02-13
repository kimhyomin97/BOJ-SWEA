import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_7490_0만들기 {
	public static StringBuilder sb = new StringBuilder();
	public static int size;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 0 < n < 10
		
		for(int i=0; i<n; i++) {
			size = Integer.parseInt(br.readLine()); // 3 <= n <= 9
			recur(1, new Stack<String>(), 1, 1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

	public static void recur(int num, Stack<String> list, int sum, int before) {
		if(num == size) {
			if(sum == 0) {
				for(int i=0; i<list.size(); i++) {
					sb.append(i+1);
					sb.append(list.get(i));
				}
				sb.append(list.size()+1);
				sb.append("\n");
			}
			return;
		}
		if(list.size() == 0) {
			list.add(" ");
			recur(num+1, list, sum-before+(before*10 + num+1), (before*10 + num+1));
			list.pop();
		} else {
			String sign = list.peek();
			list.add(" ");
			if("+".equals(sign)) {
				recur(num+1, list, sum-before+(before*10 + num+1), (before*10 + num+1));
			} else if("-".equals(sign)) {
				recur(num+1, list, sum-before+(before*10 - (num+1)), (before*10 + num+1) * -1);
			} else if(" ".equals(sign)) {
				recur(num+1, list, sum-before+(before*10 + num+1), (before*10 + num+1));
			}
			list.pop();
		}
		list.add("+");
		recur(num+1, list, sum+num+1, num+1);
		list.pop();
		list.add("-");
		recur(num+1, list, sum-(num+1), (num+1)*-1);
		list.pop();
	}
}
