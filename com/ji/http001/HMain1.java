package com.ji.http001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

//	HTTP 통신 > Client가 Request하면 Server가 Response함.
//	과거 Java에는 HTTP 통신을 위한 client 기능이 존재x > 개발해야 함.
//	현재 java에는 다른 개발자가 개발해서 공개 해놨음. -jar로. > 코드는 못 보지만 기능 사용은 가능함.

public class HMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DefaultHttpClient dhc = new DefaultHttpClient();

			// HTTP Request : GET(기본) / POST
			HttpGet hg = new HttpGet("https://www.naver.com/");

			// 응답
			HttpResponse hr = dhc.execute(hg);

			// 응답 내용
			HttpEntity he = hr.getEntity();

			InputStream is = he.getContent();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
