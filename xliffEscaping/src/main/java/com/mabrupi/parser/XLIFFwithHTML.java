package com.mabrupi.parser;

public class XLIFFwithHTML {
	
	int id;
	int rid;
	
	public XLIFFwithHTML(){
		
	}
	
	public String parse(String parse){
		if(parse == null) return "";
		if(parse.isEmpty()) return "";
		if(!parse.contains("<source>")) return parse;
		return getParseResult(parse);
	}
	
	private String getParseResult(String toParse){
		StringBuffer result = new StringBuffer();
		//We assume an alone source block
		int iniPosSource = toParse.indexOf("<source>"); 
		int finPosSource = toParse.indexOf("</source>");
		result.append(toParse.substring(0, iniPosSource));
		result.append(escapeHTML(toParse.substring(iniPosSource, finPosSource)));
		result.append(toParse.substring(finPosSource));
		return result.toString();
	}
	
	private String escapeHTML(String toEscape){
		return toEscape;
	}
	
}
