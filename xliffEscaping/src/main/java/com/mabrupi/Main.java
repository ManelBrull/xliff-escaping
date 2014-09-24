package com.mabrupi;

import com.mabrupi.parser.XLIFFwithHTML;

public class Main {

	public static void main(String[] args) {
		XLIFFwithHTML parser = new XLIFFwithHTML();
		String toParse = "<source>Hello <b>ola</b> world</source>";
		String result = parser.parse(toParse);
		System.out.println("Result: " + result);
	}

}
