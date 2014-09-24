package com.mabrupi;

import com.mabrupi.parser.XLIFFwithHTML;

public class Main {

	public static void main(String[] args) {
		XLIFFwithHTML parser = new XLIFFwithHTML();
		String toParse = "<source>I'm <b>really</b> <b>really <b>really</b></b> sure about this.</source>";
		String result = parser.parse(toParse);
		System.out.println("Result: " + result);
	}

}
