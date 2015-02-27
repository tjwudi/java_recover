package com.wudi;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SquareDigit().squareDigits(522);
	}

}


class SquareDigit {

	  public int squareDigits(int n) {
	    String nstr = new Integer(n).toString();
	    String result = "";
	    for (int i = 0; i < nstr.length(); i ++) {
	    	int digit = (int)nstr.charAt(i) - (int)'0';
	    	result += new Integer(digit*digit).toString();
	    }
	    System.out.println(result);
	    return Integer.parseInt(result);
	  }

	}