package com.mabrupi;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
				result.toString());
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
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Opening tag simple: source || " + returnValue.toString(),
					"source",
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
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Opening tag simple: source || " + returnValue.toString(),
					"source",
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
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Closing tag simple: source || " + returnValue.toString(),
					"source",
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
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertNotNull("Empty return value", returnValue);
			Assert.assertEquals(
					"Closing tag simple: source || " + returnValue.toString(),
					"source",
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
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Content problems",
					"Hello world",
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
		
		try {
			Method method = parser.getClass().getDeclaredMethod(nameMethod, String.class);
			method.setAccessible(true);
			String returnValue = (String) method.invoke(parser, toParse);
			Assert.assertEquals(
					"Content problems",
					"Hello world",
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
		String opNameMethod = "generateOpeningEscapeTag";
		String toParse = "b";
		
		// first we invoke generateOpeningTag
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
		String opNameMethod = "generateOpeningEscapeTag";
		String toParse = "source";
		
		// first we invoke generateOpeningTag
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
	
	
	/**
	@Test
	public void testSingleTag1(){
		String toParse = "<source>I'm <b>really</b> sure about this.</source>";
		String expected  = "<source>I'm <bpt id=\"0\" rid=\"0\">&lt;b&gt;</bpt>"
				+ "really<ept id\"1\" rid=\"0\">&lt;/b&gt;</ept>"
				+ " sure about this.</source>";
		
		System.out.println("Expected: " + expected);
		String result = parser.parse(toParse);
		System.out.println("result: " + result);
		
		Assert.assertEquals("Source with html b tag",
				expected,
				result);
	}
	**/
	
}
