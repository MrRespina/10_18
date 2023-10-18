package com.ji.socket001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

//.158 / 14.32.49.109
//	통신
//		일반적 통신(요청 > 응답) HTTP 통신
//		실시간 통신(냅다 답이 옴?) Socket통신

//	서버 - 서비스 제공 컴퓨터
//	클라이언트 - 서비스 이용 컴퓨터

// PORT
//	WEB Service : 80
//	OracleDB : 1521
//	이미 약속된 포트가 있으므로 4자리 넘게 지정할 것.
//
public class SSMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(7524);
			System.out.println("서버 연결 : ");

			Socket s = ss.accept();
			System.out.println("연결됨.");

			Scanner k = new Scanner(System.in);

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			JFrame jf = new JFrame();
			JTextArea jta = new JTextArea();

			jf.add(jta);
			jf.setSize(500, 500);
			jf.setVisible(true);

			Thread t = new Thread() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();

					while (true) {
						try {
							jta.append("상대] " + br.readLine() + "\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			};
			t.start();

			while (true) {
				System.out.println("나] ");
				String msg = k.nextLine();
				bw.write(msg + "\n");
				jta.append("나] " + msg + "\n");
				bw.flush();
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
