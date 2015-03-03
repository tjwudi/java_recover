package com.wudi.lc2;

import java.util.ArrayList;
import java.util.List;

public class LCSpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCSpiralMatrix lc = new LCSpiralMatrix();
		Solution sl = lc.new Solution();
		List<Integer> result = sl.spiralOrder(new int[][] { { 1 , 2 , 3 }, {4,5,6},{7,8,9}  });
		result = null;
	}

	public class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> list = new ArrayList<>();
	        int lowerBound = 0, upperBound = matrix.length - 1; // [lowerBound, upperBound]
	        while (upperBound >= lowerBound) {
	            for (int i = lowerBound; i <= upperBound; i ++) list.add(matrix[lowerBound][i]);
	            for (int i = lowerBound + 1; i <= upperBound; i ++) list.add(matrix[i][upperBound]);
	            for (int i = upperBound - 1; i >= lowerBound; i --) list.add(matrix[upperBound][i]);
	            for (int i = upperBound - 1; i >= lowerBound + 1; i --) list.add(matrix[i][lowerBound]);
	            upperBound --;
	            lowerBound ++;
	        }
	        return list;
	    }
	}
}
