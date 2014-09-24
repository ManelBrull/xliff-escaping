package com.mabrupi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mabrupi.parser.XLIFFwithHTML;

public class XLIFFwithHTMLPublicTest {
	
	XLIFFwithHTML parser;
	
	
	@Before
	public void initialize(){
		parser = new XLIFFwithHTML();
	}
	
	@Test
	public void testEmpty() {
		String result = parser.parse("");
		Assert.assertEquals("Empty input equals empty output",
				"",
				result);
	}
	
	@Test
	public void testHelloWorld() {
		String toParse = "<source>Hello world</source>";
		String result = parser.parse(toParse);
		Assert.assertEquals("Single source without tags",
				toParse,
				result.toString());
	}
	
	@Test
	public void testSingleTag(){
		String toParse = "<source>I'm <b>really</b> sure about this.</source>";
		String expected  = "<source>I'm <bpt id=\"0\" rid=\"0\">&lt;b&gt;</bpt>"
				+ "really<ept id=\"1\" rid=\"0\">&lt;/b&gt;</ept>"
				+ " sure about this.</source>";
		String result = parser.parse(toParse);
		Assert.assertEquals("Source with html b tag",
				expected,
				result);
	}
	
	@Test
	public void testNestedTag(){
		String toParse = "<source>I'm <b>really <b>AMAZING </b>sure </b>about this.</source>";
		String expected  = "<source>I'm <bpt id=\"2\" rid=\"1\">&lt;b&gt;</bpt>really " 
				
				+ "<bpt id=\"0\" rid=\"0\">&lt;b&gt;</bpt>AMAZING "
				+ "<ept id=\"1\" rid=\"0\">&lt;/b&gt;</ept>"
				+ "sure <ept id=\"3\" rid=\"1\">&lt;/b&gt;</ept>"
				
				+ "about this.</source>";
		
		String result = parser.parse(toParse);
		
		Assert.assertEquals("Source with html b tag",
				expected,
				result);
	}
	
	@Test
	public void testMultipleTag(){
		String toParse = "<source>I'm <b>really</b> <b>really <b>really</b></b> sure about this.</source>";
		String expected  = "<source>I'm <bpt id=\"0\" rid=\"0\">"
				+ "&lt;b&gt;</bpt>really<ept id=\"1\" rid=\"0\">"
				+ "&lt;/b&gt;</ept><bpt id=\"4\" rid=\"2\">&lt;b&gt;</bpt>"
				+ "really <bpt id=\"2\" rid=\"1\">&lt;b&gt;</bpt>"
				+ "really<ept id=\"3\" rid=\"1\">&lt;/b&gt;</ept>"
				+ "<ept id=\"5\" rid=\"2\">&lt;/b&gt;</ept>"
				+ " sure about this.</source>";
		String result = parser.parse(toParse);
		Assert.assertEquals("Source with html b tag",
				expected,
				result);
	}
}
