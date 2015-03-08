package com.wudi.hr;

import java.util.Scanner;

public class BiggerIsGreater {
	public static void main(String[] args) {
		int T;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		while (T -- > 0) {
			String s = in.next();
			int len = s.length();
			String result = "no answer";
			
			int r = len - 1, l;
			while (r >= 0) {
				l = r;
				while (l > 0 && s.charAt(l) == s.charAt(l-1)) l--;
				if (l == 0) break;
				if (s.charAt(l-1)<s.charAt(r)) {
					//swap char at l-1 and r
					StringBuilder sb = new StringBuilder(s);
					sb.replace(l-1, l, s.substring(r,r+1));
					sb.replace(r, r+1, s.substring(l-1,l));
					result = sb.toString();
					break;
				}
				r = l - 1;
			}
			
			System.out.println(result);
		}
	}
}
