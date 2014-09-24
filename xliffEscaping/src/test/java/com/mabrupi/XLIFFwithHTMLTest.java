package com.mabrupi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mabrupi.parser.XLIFFwithHTML;

public class XLIFFwithHTMLTest {

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
				result);
	}
	
	@Test
	public void testGetNameOpeningTagSimple() {
		
	}
	
	@Test
	public void testGetNameOpeningTagComplex() {
		
	}
/**	
	@Test
	public void testSingleTag1(){
		String toParse = "<source>I'm <b>really</b> sure about this.</source>";
		String expected  = "<source>I'm <bpt id=\"0\" rid=\"0\">&lt;b&gt;</bpt>"
				+ "really>ept id\"1\" rid=\"0\">&lt;/b&gt;</ept>"
				+ " sure about this.</source>";
		String result = parser.parse(toParse);
		Assert.assertEquals("Source with html b tag",
				expected,
				result);
	}
	**/
}
