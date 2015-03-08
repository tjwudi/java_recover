package com.wudi.hr;

import java.util.Scanner;

public class Clique {
	private static boolean test(int M, int testN) {
		return testN * (testN - 1) / 2 <= M;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt(), 
				M = in.nextInt(),
				l = 2,
				r = N,
				ans = -1;
			while (l <= r) {
				int mid = (l + r) / 2;
//				System.out.println(String.format("l:%d r:%d mid:%d", l, r, mid));
				if (test(M, mid)) {
					l = mid + 1;
					ans = mid;
				}
				else {
					r = mid - 1;
				}
			}
			System.out.println(ans);
		}
		in.close();
	}
}
