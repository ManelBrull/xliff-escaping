package com.mabrupi;

import org.junit.Assert;
import org.junit.Test;

import com.mabrupi.parser.XLIFFwithHTML;

public class XLIFFwithHTMLTest {

	@Test
	public void testEmpty() {
		String result = XLIFFwithHTML.parse("");
		Assert.assertEquals("Empty input equals empty output",
				"",
				result);
	}
	
	@Test
	public void testHelloWorld() {
		String toParse = "<source>Hello world</source>";
		String result = XLIFFwithHTML.parse(toParse);
		Assert.assertEquals("Empty input equals empty output",
				toParse,
				result);
	}
	
	@Test
	public void testSingleTag1(){
		String toParse = "<source>I'm <b>really</b> sure about this.</source>";
		String expected  = "<source>I'm <bpt id=\"0\" rid=\"0\">&lt;b&gt;</bpt>"
				+ "really>ept id\"1\" rid=\"0\">&lt;/b&gt;</ept>"
				+ " sure about this.</source>";
		String result = XLIFFwithHTML.parse(toParse);
		Assert.assertEquals("Empty input equals empty output",
				expected,
				result);
	}
}
