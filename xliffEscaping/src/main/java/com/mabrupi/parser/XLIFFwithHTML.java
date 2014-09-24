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
		//we assume only one source block
		int iniPosSource = toParse.indexOf("<source>"); 
		int finPosSource = toParse.lastIndexOf("</source>")+"</source>".length();
		result.append(toParse.substring(0, iniPosSource));
		result.append(parseBlock(
				toParse.substring(iniPosSource, finPosSource)));
		result.append(toParse.substring(finPosSource));
		return result.toString();
	}
	
	private String parseBlock(String toEscape){
		int iniTagPosIndex = toEscape.indexOf("<");
		if(iniTagPosIndex == -1) return toEscape;
		
		if(continueRecursion(toEscape)){
			parseBlock(getNestedTag(toEscape));
		}
		// here it comes the cange of the tag		
		
		return toEscape;
	}
	
	private boolean continueRecursion(String str) {
		int firstTagIniPos = str.indexOf(">");
		int firstTagEndPos = str.lastIndexOf("</");
		
		int nestedTagIniPos = str.indexOf("<", firstTagIniPos);
		int nestedTagEndPos = str.lastIndexOf(">", firstTagEndPos);
		if(nestedTagIniPos == firstTagEndPos)
			return false;
		return true;
	}
	
	private String getNestedTag(String str){
		int firstTagIniPos = str.indexOf(">");
		int firstTagEndPos = str.lastIndexOf("</");
		
		int nestedTagIniPos = str.indexOf("<", firstTagIniPos);
		int nestedTagEndPos = str.lastIndexOf(">", firstTagEndPos);
		
		return str.substring(nestedTagIniPos, nestedTagEndPos);
	}
	
	
	
}
