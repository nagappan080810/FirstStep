package com.firststep.tutorial;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface MessageName {
	String messagestr() default "BaseClass"; 
	public enum Greeting{
		HELLO, THANKS
	}
	Greeting greeting() default Greeting.HELLO;
	String[] tags() default {"phone","bag"}; 
}
