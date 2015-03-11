package com.wudi.winwin;

public class Num1s {
	public static void main(String[] args) {
		int n = 43261596;
        int ans = 0;
        int remain = 32;
        while (n != 0) {
            int bit = (n & 1);
            System.out.print(bit + " ");
            n >>>= 1;
            ans = (ans << 1) + bit;
            remain --;
        }
        ans <<= remain;
        System.out.println(ans);
	}
}
