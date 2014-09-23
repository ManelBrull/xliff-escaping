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
	
	/**@Test
	public void testHelloWorld() {
		String toParse = "<source>Hello world</source>";
		String result = XLIFFwithHTML.parse(toParse);
		Assert.assertEquals("Empty input equals empty output",
				toParse,
				result);
	}**/
}
