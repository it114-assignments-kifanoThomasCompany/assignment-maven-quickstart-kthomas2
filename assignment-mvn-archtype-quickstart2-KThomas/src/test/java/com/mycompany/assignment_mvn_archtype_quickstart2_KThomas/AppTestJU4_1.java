package com.mycompany.assignment_mvn_archtype_quickstart2_KThomas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mycompany.assignment_mvn_archtype_quickstart2_KThomas.common.CannotParse2IntegerException;

public class AppTestJU4_1 {
	
	private String  name;
	private Integer age;
	private App     app;
		
	public static Integer age2add = 10;
	public static String  strAge2add = "20";
	public static String  exceptionStrAge2add = "there She Throws";
	
	public static final String  DEFAULT_NAME = "Loner";
	public static final Integer DEFAULT_AGE = 25;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BEOF setUpBeforeClass of AppTestJU4_1");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("BEOF tearDownAfterClass of AppTestJU4_1");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("BEF setUp of AppTestJU4_1");
		name = AppTestJU4_1.DEFAULT_NAME;
		age = AppTestJU4_1.DEFAULT_AGE;
		app = new App(name, age);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("BEOF tearDown of AppTestJU4_1");
	}

	@Test
	public void testApp() {
		App app1 = new App();
		assertEquals("Name has not been initialized to expected value:" + App.NAME , app.NAME, app1.getName());
		assertEquals("Age  has not been initialized to expected value:" + App.AGE ,  app.AGE,  app1.getAge());
//		fail("Not yet implemented");
	}

//	@Test
	@Ignore
	public void testAppStringInteger() {
		App app1 = new App(name, age);
		assertEquals("Name has not been initialized to expected value:" + name , name, app1.getName());
		assertEquals("Age  has not been initialized to expected value:" + age ,  age, app1.getAge());
//		fail("Not yet implemented");
	}

	@Test
	public void testAdd2ageInteger() {
		Integer expected = age + age2add;
		Integer actual = app.add2age(age2add);
		assertEquals("add2age did not add " + age2add + " correctly", expected, actual);

	}
	
	@Test
	public void testAdd2ageString() throws CannotParse2IntegerException {
		Integer expected = age + Integer.parseInt(strAge2add);
		Integer actual = app.add2age(strAge2add);
		assertEquals("add2age did not add " + strAge2add + " correctly", expected, actual);		
//		fail("Not yet implemented");
	}
	
	@Test(expected = CannotParse2IntegerException.class)

	public void testAdd2ageStringCannotParse2IntegerException1() throws CannotParse2IntegerException {
		app.add2age(exceptionStrAge2add);
//		fail("Not yet implemented");
	}

	@Rule
	public final ExpectedException expectedException = ExpectedException.none();
	@Test

	public void testAdd2ageStringCannotParse2IntegerException2() throws CannotParse2IntegerException {
		expectedException.expect(CannotParse2IntegerException.class);
		app.add2age(exceptionStrAge2add);

	}

	@Test
	public void testAdd2ageStringCannotParse2IntegerException3() {
		try {
			app.add2age(exceptionStrAge2add);
			fail("add2age(" + exceptionStrAge2add + ") did not throw expected CannotParse2IntegerException");
		} catch (CannotParse2IntegerException e) {

		}
	}
	
	@Test
	public void testPrefixedName() {
		String prefixName = "Dr. "; 
		String expected = prefixName + name;
		String actual = app.prefixedName(prefixName);
		assertEquals("prefixedName did not add " + prefixName + " correctly", expected, actual);		
	}

}



