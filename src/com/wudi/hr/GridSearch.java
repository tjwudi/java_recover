package com.wudi.hr;

import java.util.Scanner;

public class GridSearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T, R, C, r, c;
		T = in.nextInt();
		while (T -- > 0) {
			R = in.nextInt();
			C = in.nextInt();
			char[][] map = new char[R][C];
			for (int i = 0; i < R; i ++) {
				String str = in.next();
				for (int j = 0; j < C; j ++) 
					map[i][j] = str.charAt(j);
			}
			r = in.nextInt();
			c = in.nextInt();
			char[][] pattern = new char[r][c];
			for (int i = 0; i < r; i ++) {
				String str = in.next();
				for (int j = 0; j < c; j ++) 
					pattern[i][j] = str.charAt(j);
			}
			MySolution sl = new MySolution(map, pattern, R, C, r, c);
			System.out.println(sl.solve());
		}
		in.close();
	}
}

class MySolution {
	private int R, C, r, c;
	private char[][] map, pattern;
	
	private boolean test(int x, int y) {
		for (int i = 0; i < r; i ++)
			for (int j = 0; j < c; j ++)
				if (pattern[i][j] != map[i+(x-r+1)][j+(y-c+1)])
					return false;
		return true;
	}
	
	
	public String solve() {
		for (int i = r - 1; i < R; i ++)
			for (int j = c - 1; j < C; j ++) {
				if (map[i][j] == pattern[r-1][c-1] &&
					map[i-r+1][j-c+1] == pattern[0][0] &&
					map[i][j-c+1] == pattern[r-1][0] &&
					map[i-r+1][j] == pattern[0][c-1] &&
					test(i, j)) {
						return "YES";
					}
 			}
		return "NO";
	}
	
	MySolution(char[][] map, char[][] pattren, int R, int C, int r, int c) {
		this.R = R;
		this.C = C;
		this.r = r;
		this.c = c;
		this.map = map;
		this.pattern = pattren;
	}
}
