package com.wudi.hr;

import java.util.Scanner;

public class CircleCity {
	private static int[] squares = new int[45000];
	private static Scanner in = new Scanner(System.in);
	
	static {
		for (int i = 0; i < squares.length; i ++) 
			squares[i] = i * i;
	}
	
	public static void main(String[] args) throws Exception {
		int T = in.nextInt();
		while (T-- > 0) {
			// initialization
			int d, k, ans;
			d = in.nextInt();
			k = in.nextInt();
			ans = 0;
			

			// two pointers' algo
			int l, r;
			double sqrtD = Math.sqrt(d);
			l = 1;
			r = (int) Math.floor(sqrtD);
			while (l <= r) {
				int sum = squares[l] + squares[r];
				if (sum == d) {
					ans += (l == r) ? 1 : 2;
					l ++;
					r --;
				}
				else if (sum < d) l ++;
				else r --;
			}
			ans *= 4;
			
			
			// 四个轴上的点
			if (Math.abs(Math.floor(sqrtD) - sqrtD) < 1e-8) {
				// 完全平方数
				ans += 4;
			}
			
			// Output
			System.out.println(ans <= k ? "possible" : "impossible");
		}
	}
}
