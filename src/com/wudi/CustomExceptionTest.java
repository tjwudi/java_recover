package com.wudi;

public class CustomExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		throw new WDException();
	}

}


class WDException extends RuntimeException {
	
}