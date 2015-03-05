package com.wudi.net;

import java.net.*;

public class WhoAmI {
	public static void main(String[] args) throws Exception  {
		InetAddress a = InetAddress.getByName("www.leapoahead.com");
		System.out.println(a);
	}
}
