package com.firststep.tutorial;

import java.lang.annotation.Annotation;

public class AnnotationReader {
	public static void main(String args[]){
		printBaseAnnotation();
		printSubAnnotation();
	}
	public static void printBaseAnnotation(){
		Class<BaseClass> b1 = BaseClass.class;
		Annotation annotations = b1.getAnnotations()[0];
		MessageName messageName = (MessageName) annotations;
		System.out.println(messageName.messagestr());
		System.out.println(messageName.tags().length);
		System.out.println(messageName.greeting());
	}
	public static void printSubAnnotation(){
		Class<SubClass> b1 = SubClass.class;
		Annotation annotations = b1.getAnnotations()[0];
		MessageName messageName = (MessageName) annotations;
		System.out.println(messageName.messagestr());
		System.out.println(messageName.tags().length);
		System.out.println(messageName.greeting());
	}
}
