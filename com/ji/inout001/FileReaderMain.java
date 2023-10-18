package com.ji.inout001;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;

		try {
			fr = new FileReader("C:\\Users\\sdedu\\Desktop\\pin\\Res.txt");
			br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
