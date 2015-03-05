package com.wudi.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class JabberClient {
	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getByName(null);
		Socket socket = new Socket(addr, JabberServer.PORT);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			for (int i = 0; i < 10; i ++) {
				out.println(String.format("Howdy %d", i));
				String str = in.readLine();
				System.out.println(str);
			}
			out.println("END");
		}
		finally {
			System.out.println("Closing");
			socket.close();
		}
	}
}
