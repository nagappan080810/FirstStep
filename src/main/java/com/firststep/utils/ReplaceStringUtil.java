package com.firststep.utils;

import org.apache.commons.lang.StringUtils;

public class ReplaceStringUtil {
	public static void main(String args[]){
		String ddAppURL = "/AutoHome/Start?EDUID={EDUID}";
		String eduId = StringUtils.repeat("A", 255);
		ddAppURL = ddAppURL.replaceAll("\\{EDUID\\}",eduId);
		System.out.println("replaced string-"+ddAppURL);
	}

}
