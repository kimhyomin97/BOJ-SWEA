package ����;

import java.util.Scanner;

public class ���� {
	static int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է� : ");
//		int num = sc.nextInt();
		num = sc.nextInt();
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.print("\n");
//		}
		myprint(num);
	}
	
	private static void myprint(int num) {
		for(int i=0; i<num; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}
