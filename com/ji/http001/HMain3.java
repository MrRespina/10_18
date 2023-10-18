package com.ji.http001;

import java.io.InputStream;

public class HMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String address = "https://www.google.com";
			InputStream is = JiHttpClient.download(address);
			
			String result = JiHttpClient.convert(is, "UTF-8");
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}
