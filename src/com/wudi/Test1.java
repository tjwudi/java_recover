package com.wudi;

class Person {
	static String uuid = "abcd";
	static {
		uuid = "abc";
	}
	
	void task1() {
		int[] a = { 1, 2 ,3 };
		System.out.println(a[1]);
	}
}

public class Test1 {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Person.uuid);
		
		Person p = new Person();
		p.task1();
	}

}
