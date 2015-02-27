package com.wudi;

import java.util.Arrays;
import java.util.Random;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GiftSorter().sortGiftCode("abcesd"));
	}

}


class GiftSorter{
	  public String sortGiftCode(String code){
	    String[] chars = code.split("");
	    Arrays.sort(chars);
	    return String.join(" ", chars);
	  }
	}