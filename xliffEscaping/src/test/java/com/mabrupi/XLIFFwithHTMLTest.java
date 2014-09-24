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
