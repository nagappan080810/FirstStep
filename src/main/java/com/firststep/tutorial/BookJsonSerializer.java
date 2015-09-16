package com.firststep.tutorial;
import java.text.*;
import java.util.*;
import java.io.*;

import net.sf.json.*;

import org.codehaus.jackson.*;
import org.codehaus.jackson.map.*;

public class BookJsonSerializer {
	public static void main(String args[]) throws ParseException, JsonGenerationException, JsonMappingException, IOException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm-dd-yy");
		Date d1 = simpleDateFormat.parse("07-03-14");
		Book b1 = new Book(1, "Learn Java", d1, "James Gosling", 23.50);
		JSON b1Json = JSONSerializer.toJSON(b1);
		System.out.println(b1Json.toString());
		Object b2 = JSONSerializer.toJava(b1Json);
		System.out.println("b2-"+b2);
		//jackson conversion.
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("book.json"), b1);
		Book b3 = mapper.readValue(new File("book.json"), Book.class);
		System.out.println("jackson b3-"+b3);
		
	}

}
