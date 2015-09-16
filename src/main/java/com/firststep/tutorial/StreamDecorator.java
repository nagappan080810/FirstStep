package com.firststep.tutorial;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class StreamDecorator {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		 PipedInputStream pipedInputStream = new PipedInputStream();
		    PipedOutputStream pipedOutputStream = new PipedOutputStream();
		    pipedOutputStream.connect(pipedInputStream);
		    //writing 
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStream);
		    FilterOutputStream objectOutputStreamWrapper = new FilterOutputStream(objectOutputStream);
		    //ObjectOutputStream objectOutputStreamWrapper1 = new ObjectOutputStream(objectOutputStreamWrapper);
		    byte b[] = new byte[]{'a','c','d'};
		    objectOutputStreamWrapper.write(b);
		    objectOutputStreamWrapper.flush();
		    //objectOutputStream.writeObject("this is my string");
		    //reading 
		    ObjectInputStream objectInputStream = new ObjectInputStream(pipedInputStream);
		    ObjectInputStream objectInputStreamWrapper = new ObjectInputStream (objectInputStream);
		    //ObjectInputStream objectInputStreamWrapper1 = new ObjectInputStream(objectInputStreamWrapper);
		    //System.out.println("going to read from piped source");
		    //System.out.println(objectInputStreamWrapper1.readObject());
		    byte[] buf = new byte[3];
		    System.out.println(objectInputStreamWrapper.read(buf));
		    //close
		    objectOutputStream.close();
	}
}
