package com.wudi.hr;

import java.util.Scanner;

public class MaxSubarray {
	private static int[] arr = new int[100001];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T -- > 0) {
			int N = in.nextInt();
			boolean hasNonNegative = false;
			for (int i = 0; i < N; i ++) {
				arr[i] = in.nextInt();
				if (arr[i] >= 0) hasNonNegative = true;
			}
			
			int ans2,
				sum = 0,
				ans1 = Integer.MIN_VALUE;
			if (hasNonNegative) {
				ans2 = 0;
			}
			else {
				ans2 = Integer.MIN_VALUE;
			}
			for (int i = 0; i < N; i ++) {
				if (hasNonNegative) ans2 += (arr[i] > 0) ? arr[i] : 0;
				else ans2 = Math.max(ans2, arr[i]);
				sum += arr[i];
				ans1 = Math.max(ans1, sum);
				if (sum < 0) sum = 0;
			}
			System.out.println(String.format("%d %d", ans1, ans2));
		}
	}
}
