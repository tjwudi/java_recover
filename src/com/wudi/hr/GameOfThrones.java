package com.wudi.hr;

import java.util.Arrays;
import java.util.Scanner;

public class GameOfThrones {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        int[] record = new int[26];
        Arrays.fill(record, 0);
        int n = inputString.length();
        for (int i = 0; i < n; i ++) 
        	record[(int)inputString.charAt(i) - (int)'a'] ++;
        
        int even = 0, odd = 0;
        for (int i = 0; i < 26; i ++) {
        	if (record[i] % 2 == 0) even ++;
        	else odd ++;
        }
        if (odd <= 1) ans = "YES";
        else ans = "NO";
        
        System.out.println(ans);
        myScan.close();
    }
}
