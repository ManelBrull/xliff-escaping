package com.mabrupi.parser;

public class XLIFFwithHTML {
	
	public static String parse(String parse){
		if(parse == null) return "";
		if(parse.isEmpty()) return "";
		if(!parse.contains("<source>")) return parse;
				
		return "";
	}
	
}
