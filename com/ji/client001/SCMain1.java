package com.ji.client001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SCMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s = null;
		try {
			s = new Socket("192.168.0.158",1042);
			System.out.println("연결 완료.");
			Scanner k = new Scanner(System.in);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				System.out.printf("상대] %s\n",br.readLine());
				System.out.print("나] ");
				String msg = k.nextLine();
				bw.write(msg + "\n");
				bw.flush();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
