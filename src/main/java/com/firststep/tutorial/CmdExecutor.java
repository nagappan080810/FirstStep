package com.firststep.tutorial;
import java.io.*;
public class CmdExecutor {
	public boolean equals(String object){
		return true;
	}
	public static void main(String args[]) throws IOException{
		Process p = Runtime.getRuntime().exec("cmd");
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		//bw.write("dir");
		//bw.flush();
		//bw.close();
		CmdExecutor c1 = new CmdExecutor();
		System.out.println("equals method override and check which method is callled"+c1.equals("test")+c1.equals(2));
		String str = new String("hello");
		System.out.println("value match with == operator is "+(str=="hello")+" and equals to "+(str.equals("hello")));
		StringBuffer str1 = new StringBuffer("Sample");
		String str2 = new String("Sample2");
		System.out.println(str1.equals(str2));
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while(true){
			String line = br.readLine();
			if (line==null)
				break;
			System.out.println("entered input is "+line);
		}
	}

}
