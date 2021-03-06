package com.mabrupi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mabrupi.parser.XLIFFwithHTML;

public class XLIFFwithHTMLPrivateTest {

	XLIFFwithHTML parser;
	
	
	@Before
	public void initialize(){
		parser = new XLIFFwithHTML();
	}
	
	@Test
	public void testGetNestedTagSimple() {
		String nameMethod = "getNestedTag";
		String toParse = "<source>Hello <b>nested tag</b> world</source>";
		String resultExpected = "<b>nested tag</b>";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Nested tag",
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGetNestedTagComplex() {
		String nameMethod = "getNestedTag";
		String toParse = "<source>Hello <b></b> world</source>";
		String resultExpected = "<b></b>";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Nested tag",
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	@Test
	public void testGetNameOpeningTagSimple() {
		String nameMethod = "getNameOpeningTag";
		String toParse = "<source>Hello world</source>";
		String resultExpected = "source";
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Opening tag simple: source || " + returnValue.toString(),
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	
	@Test
	public void testGetNameOpeningTagComplex() {
		String nameMethod = "getNameOpeningTag";
		String toParse = "Something to make it more complex <source>Hello world</source>";
		String resultExpected = "source";
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Opening tag simple: source || " + returnValue.toString(),
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGetNameClosingTagSimple() {
		String nameMethod = "getNameClosingTag";
		String toParse = "<source>Hello world</source>";
		String resultExpected = "source";
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Closing tag simple: source || " + returnValue.toString(),
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	@Test
	public void testGetNameClosingTagComplex() {
		String nameMethod = "getNameClosingTag";
		String toParse = "Something to make it more complex <source>Hello world</source> Something to make it more complex ";
		String resultExpected = "source";
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Closing tag simple: source || " + returnValue.toString(),
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGetContentBetweenTagsSimple() {
		String nameMethod = "getContentBetweenTags";
		String toParse = "<source>Hello world</source>";
		String expectedResult = "Hello world"; 
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Content problems",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	@Test
	public void testGetContentBetweenTagsComplex() {
		String nameMethod = "getContentBetweenTags";
		String toParse = "Something to make it more complex <source>Hello world</source> Something to make it more complex ";
		String resultExpected = "Hello world";
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Content problems",
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGetContentBetweenTagsEmpty() {
		String nameMethod = "getContentBetweenTags";
		String toParse = "Something to make it more complex <source></source> Something to make it more complex ";
		boolean resultExpected = true;
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertTrue(returnValue.isEmpty());
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGenerateOpeningEscapeTagSimple() {
		String nameMethod = "generateOpeningEscapeTag";
		String toParse = "b";
		String expectedResult="<bpt id=\"0\" rid=\"0\">&lt;" + toParse +
				"&gt;</bpt>";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Opening escape",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGenerateOpeningEscapeTagSource() {
		String nameMethod = "generateOpeningEscapeTag";
		String toParse = "source";
		String expectedResult="<source>";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Opening escape",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGenerateClosingEscapeTagSimple() {
		// first we invoke generateOpeningTag. This is not the test
		String opNameMethod = "generateOpeningEscapeTag";
		String toParse = "b";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(opNameMethod, String.class);
			method.setAccessible(true);
			method.invoke(parser, toParse);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + opNameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + opNameMethod);
		}
		
		//here starts our real test
		String nameMethod = "generateClosingEscapeTag";
		String expectedResult="<ept id=\"1\" rid=\"0\">&lt;/" + toParse +
				"&gt;</ept>";
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Closing escape",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testGenerateClosingEscapeTagSource() {
		// first we invoke generateOpeningTag, this is not the test
		String opNameMethod = "generateOpeningEscapeTag";
		String toParse = "source";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(opNameMethod, String.class);
			method.setAccessible(true);
			method.invoke(parser, toParse);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + opNameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + opNameMethod);
		}
		
		//Here starts our test
		String nameMethod = "generateClosingEscapeTag";
		String expectedResult="</source>";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Closing escape",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testParseBlockSimple() {
		String nameMethod = "parseBlock";
		String toParse = "<source>Hello world</source>";
		String expectedResult = "<source>Hello world</source>";
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"parse block problems",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	@Test
	public void testParseBlockComplex() {
		String nameMethod = "parseBlock";
		String toParse = "<b>Hello world</b>";
		String expectedResult = 
				"<bpt id=\"0\" rid=\"0\">&lt;" + "b" + "&gt;</bpt>" +
				"Hello world" + 
				"<ept id=\"1\" rid=\"0\">&lt;/" + "b" + "&gt;</ept>";
				
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"parse block problems",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	@Test
	public void testSubstituteNested() {
		String nameMethod = "substituteNested";
		String toEscape = "<source>I'm <b>really</b> sure about this.</source>";
		String escaped = "<bpt id=\"0\" rid=\"0\">&lt;b&gt;</bpt>really<ept id=\"1\" rid=\"0\">&lt;/b&gt;</ept>";
		String expectedResult = "<source>I'm <bpt id=\"0\" rid=\"0\">&lt;b&gt;</bpt>really<ept id=\"1\" rid=\"0\">"+
				"&lt;/b&gt;</ept> sure about this.</source>";
				
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toEscape, escaped);
			Assert.assertEquals(
					"Substitue nested problems",
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	@Test
	public void testIsTagFollowedByClosingTagSimple(){
		String nameMethod = "isTagFollowedByClosingTag";
		String toParse = "<b>nested tag</b>";
		boolean resultExpected = true;
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			boolean returnValue = (boolean) method.invoke(parser, toParse);
			Assert.assertEquals(
					"check if the next tag is the same and is to close",
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	@Test
	public void testIsTagFollowedByClosingTagComplex(){
		String nameMethod = "isTagFollowedByClosingTag";
		String toParse = "<b>nested <b> nested tag </b> tag</b>";
		boolean resultExpected = false;
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			boolean returnValue = (boolean) method.invoke(parser, toParse);
			Assert.assertEquals(
					"check if the next tag is the same and is to close",
					resultExpected,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	
	}
	
	@Test
	public void testLeftHalf() {
		String nameMethod = "leftHalf";
		String toParse = "<b> left </b> <b> right </b>";
		String expectedResult="<b> left </b>";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testRightHalf() {
		String nameMethod = "rightHalf";
		String toParse = "<b> left </b> <b> right </b>";
		String expectedResult=" <b> right </b>";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					expectedResult,
					returnValue);
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	@Test
	public void testRightHalfComplex() {
		String nameMethod = "rightHalf";
		String toParse = "<b> left </b>";
		String expectedResult="";
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertTrue(
					returnValue.isEmpty());
		} catch (NoSuchMethodException | SecurityException e) {
			Assert.fail("cannot get declared method: " + nameMethod);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			Assert.fail("cannot invoke declared method: " + nameMethod);
		}
	}
	
	
	
	
}
