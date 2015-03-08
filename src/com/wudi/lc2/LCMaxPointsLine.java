package com.wudi.lc2;

import java.util.Scanner;

public class LCMaxPointsLine {
	public static void main(String[] args) {
		LCMaxPointsLine lc = new LCMaxPointsLine();
		Solution sl = lc.new Solution();
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Point[] points = new Point[N];
		for (int i = 0; i < N; i ++) {
			int x = in.nextInt();
			int y = in.nextInt();
			points[i] = new Point(x,y);
		}
		System.out.println(sl.maxPoints(points));
	}
	
	
	public class Solution {
		private Point makeVector(Point pS, Point pE) {
			return new Point(pE.x - pS.x, pE.y - pS.y);
		}
		
		private boolean isParallelVector(Point vecA, Point vecB) {
			return vecA.x*vecB.y == vecA.y*vecB.x;
		}
		
		private boolean parallel(final Point pA, final Point pB, final Point pC) {
			Point vecAB = makeVector(pA, pB);
			Point vecAC = makeVector(pA, pC);
			return isParallelVector(vecAB, vecAC);
		}
		
	    public int maxPoints(Point[] points) {
	        int n = points.length;
	        int ans = 0;
	        
	        for (int i = 0; i < n; i ++) 
	        	for (int j = i + 1; j < n; j ++) {
	        		if (points[i].x==points[j].x&&points[i].y==points[j].y)
	        			continue;
	        		int curAns = 2;
	        		for (int p = 0; p < n; p ++) 
	        			if (p != i && p != j) 
	        				if (parallel(points[i], points[j], points[p])) {
	        					curAns ++;
	        				}
	        		ans = Math.max(ans, curAns);
	        	}
	        return ans >= 2 ? ans : points.length;
	    }
	}
}
