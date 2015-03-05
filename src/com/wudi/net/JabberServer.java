package com.wudi.net;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
public class JabberServer {
	public static final int PORT = 8080;
	
	public static void main(String[] args) throws IOException {
		ServerSocket serv = new ServerSocket(PORT);
		
		try {
			System.out.println("Waiting for connection");
			Socket socket = serv.accept();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				while (true) {
					String str = in.readLine();
					if (str.equals("END")) break;
					System.out.println(String.format("[Client] %s", str));
					out.println(str);
				}
			}
			finally {
				System.out.println("Closing connection");
				socket.close();
			}
		}	
		finally {
			serv.close();
		}
	}
}
