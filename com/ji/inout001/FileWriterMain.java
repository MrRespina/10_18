package com.ji.inout001;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class FileWriterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);	
		String res = "C:\\Users\\sdedu\\Desktop\\pin\\Res.txt";
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(res,true);
			bw = new BufferedWriter(fw);
			
			//	상단 경로 부분에 true를 사용해야 append가 적용
			//	true를 사용하지 않으면 append를 해도 덮어쓰기
			System.out.println("현재 선택된 경로 및 파일 : "+res);
			System.out.print("파일에 입력할 텍스트를 입력해주세요 : ");
			String text = s.nextLine();
			bw.append(text+"\n");
			bw.flush();
			System.out.println("입력 완료 !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
