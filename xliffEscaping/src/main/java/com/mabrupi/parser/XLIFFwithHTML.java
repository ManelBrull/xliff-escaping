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
		
		if(doRecursion(toEscape)){
			System.out.println("I do recursion with: " + toEscape);
			parseBlock(getNestedTag(toEscape));
			
		} else {
			System.out.println("I don't do recursion with: " + toEscape);
			//return createEscapeTags(toEscape);
			return toEscape;
		}
		
		return toEscape;
	}
	
	private boolean doRecursion(String str) {
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
	
	private String createEscapeTags(String str){
		if(!getNameOpeningTag(str).equals(getNameClosingTag(str)))
			return "error parsing in: " + str + ";;";
		StringBuffer result = new StringBuffer();
		result.append(generateOpeningEscapeTag(getNameOpeningTag(str)));
		result.append(getContentBetweenTags(str));
		result.append(generateClosingEscapeTag(getNameClosingTag(str)));
		return result.toString();
	}
	
	private String getNameOpeningTag(String str){
		int iniPos = str.indexOf("<")+1;
		int finPos = str.indexOf(">");
		return str.substring(iniPos, finPos);
	}
	
	private String generateOpeningEscapeTag(String nameTag) {
		if(nameTag.equals("source")) return "<source>";
		StringBuffer result = new StringBuffer();
		result.append("<bpt id=\"").append(String.valueOf(id)).append("\"");
		id++;
		result.append(" rid=\"").append(String.valueOf(rid)).append("\">");
		result.append("&lt;").append(nameTag).append("&gt;</bpt>");
		return result.toString();
	}
	
	private String getNameClosingTag(String str) {
		int iniPos = str.lastIndexOf("</")+2;
		int finPos = str.lastIndexOf(">");
		return str.substring(iniPos, finPos);
	}
	
	private String generateClosingEscapeTag(String nameTag) {
		if(nameTag.equals("source")) return "</source>";
		StringBuffer result = new StringBuffer();
		result.append("<ept id=\"").append(String.valueOf(id)).append("\"");
		id++;
		result.append(" rid=\"").append(String.valueOf(rid)).append("\">");
		rid++;
		result.append("&lt;/").append(nameTag).append("&gt;</ept>");
		return result.toString();
	}
	
	private String getContentBetweenTags(String str){
		int iniPos = str.indexOf(">") + 1;
		int finPos = str.indexOf("</");
		if(iniPos == finPos) return "";
		return str.substring(iniPos, finPos);
	}
	
}
