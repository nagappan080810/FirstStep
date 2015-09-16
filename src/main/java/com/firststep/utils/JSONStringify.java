package com.firststep.utils;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;

public class JSONStringify {

	public static void main(String[] args) throws JSONException {
		JSONObject object = new JSONObject("test");
		JSONStringer stringer = new JSONStringer();
		JSONWriter writer = stringer.value(new String("test"));
		writer.
		
		System.out.println(stringer.value("test").toString());
		
	}

}
