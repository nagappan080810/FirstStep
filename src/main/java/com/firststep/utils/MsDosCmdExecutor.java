package com.firststep.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MsDosCmdExecutor implements Runnable {
	private String cmd = "";

	public MsDosCmdExecutor(String cmd) {
		this.cmd = cmd;
	}

	public void run() {
		try {
			String commands[] = { "CMD", "/C", cmd };
			File folder = new File("D:\\");
			ProcessBuilder processBuilder = new ProcessBuilder(commands);
			processBuilder.directory(folder);
			Process process = processBuilder.start();
			// process.wait(500);//wait for 0.5 seconds.
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			System.out.printf("Output of running %s is:\n",
					Arrays.toString(commands));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			// Wait to get exit value
			try {
				int exitValue = process.waitFor();
				System.out.println("\n\nExit Value is " + exitValue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
