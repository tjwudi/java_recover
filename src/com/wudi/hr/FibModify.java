package com.wudi.hr;

import java.math.BigDecimal;
import java.util.Scanner;


public class FibModify {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        BigDecimal A, B;
        int N;
        A = new BigDecimal(in.nextLong());
        B = new BigDecimal(in.nextLong());
        N = in.nextInt();
        BigDecimal ans = new BigDecimal(0);
        if (N == 1) ans = A;
        else if (N == 2) ans = B;
        else {
            for (int i = 3; i <= N; i ++) {
                ans = A.add(B.multiply(B));
                A = B;
                B = ans;
            }
        }
        System.out.println(ans.toString());
    }
}