package com.wudi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCReqDNARep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = new Solution1().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		result.add("");
	}

}

class Solution1 {
	private short[] rec;
	
	Solution1() { 
		this.rec = new short[2000000];
		Arrays.fill(this.rec, (short)0);
	}
	
	private int digitOf(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'T':
			return 1;
		case 'G':
			return 2;
		default:
			return 3;
		}
	}
	
	/**
	 * 
	 * @param newChar
	 * @param hashCode
	 * @param oldChar   X if no
	 * @return
	 */
	private int hash(char newChar, int hashCode, char oldChar) {
		int result = hashCode;
		if (oldChar != 'X') {
			result -= digitOf(oldChar) * Math.pow(4, 9);
		}
		result = result * 4;
		result += digitOf(newChar);
		return result;
	}
	
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;
        int hashCode = 0;
        for (int i = 0; i < 10; i ++) {
        	hashCode = hash(s.charAt(i), hashCode, 'X');
        }
        rec[hashCode] = 1;
        for (int i = 10; i < s.length(); i ++) {
        	hashCode = hash(s.charAt(i), hashCode, s.charAt(i - 10));
        	rec[hashCode] ++;
        	if (rec[hashCode] == 2) result.add(s.substring(i - 9, i + 1));
        }
        return result;
    }
}