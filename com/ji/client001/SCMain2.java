package com.ji.client001;

import java.net.Socket;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.*;

public class SCMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s = null;

		try {

			s = new Socket("192.168.0.158", 7488);
			System.out.println("연결 완료.");

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			Robot r = new Robot();

			while (true) {

				String msg = br.readLine();

				if (msg.contains(",")) {
				
					String[] xy = msg.split(",");
					System.out.println(xy[0]+" "+xy[1]);
					int x = Integer.parseInt(xy[0]);
					int y = Integer.parseInt(xy[1]);
					r.mouseMove(x, y);

				} else if (msg.equals("l")) {

					r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

				} else if (msg.equals("r")) {

					r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
					r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

				} else {
					
					break;
					
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
