package com.firststep.utils;

import java.io.*;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;

public class ProcessController {

	public static void main(String[] args) throws Exception{
		new Thread(new MsDosCmdExecutor("time")).start();
		new Thread(new MsDosCmdExecutor("time")).start();
		new Thread(new MsDosCmdExecutor("tasklist /fi \"imagename eq cmd.exe\"")).start();
	}
}
