package com.ji.socket001;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SSMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;

		try {
			ss = new ServerSocket(7524);
			System.out.println("연결 대기중 ...");

			Socket s = ss.accept();
			System.out.println("연결되었습니다. ");

			Scanner k = new Scanner(System.in);

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			while (true) {
				System.out.println("나] ");
				String msg = k.next();
				bw.write(msg + "\n");
				bw.flush();
				
				if(msg.equals("exit")) {
					ss.close();
					System.out.println("연결 종료");
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
