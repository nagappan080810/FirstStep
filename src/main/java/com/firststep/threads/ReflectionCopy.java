package com.firststep.threads;

import org.apache.commons.lang.SerializationUtils;

public class ReflectionCopy {
	
	    public static<V> V copy(V var){
	        try{ 
	            return (V) var.getClass().getConstructor(int.class).newInstance(var);
	        }
	        catch(Exception e){
	            System.out.println("Copy faield " + e.getMessage() + " ");
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public static void main(String[] args) {
	        Integer a = new Integer(3);
	        Integer b = copy(a);
	        Integer c = (Integer) SerializationUtils.clone(a);
	        

	        System.out.println(a);
	        System.out.println(b);
	        System.out.println(c);
	        System.out.println(System.identityHashCode(a) + ":" + System.identityHashCode(c));


	    }
	
}
