package io.springboot.util;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.aspectj.lang.reflect.PerClauseKind;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtil class")
class MathUtilTest {
	
	MathUtil mathUtil;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("before all");
	}
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		 
		 mathUtil = new MathUtil();
		 testReporter.publishEntry("running "+testInfo.getDisplayName() + "with tags "+testInfo.getTags());
	}
	
	@AfterEach
	void Cleanup() {
		System.out.println("after cleaning up");
	}
	
	@RepeatedTest(value = 3)
	@DisplayName("When Testing Add method")
	void testAdd(RepetitionInfo repetitionInfo) {
		 //repetitionInfo.getCurrentRepetition();
		
		int expected = 2;
		int actual = mathUtil.add(1, 1);
		assertEquals(expected, actual,"should return right sum");
	}
	
	//Nested class
	@Tag("Math")
	@Nested
	class Addtest{
		
		@Test
		@DisplayName("When Testing Add Positive numbers")
		void testAddPositive() {
			
			int expected = 2;
			int actual = mathUtil.add(1, 1);
			assertEquals(expected, actual,"add method should add two numbers");
		}
		
		@Test
		@DisplayName("Testing Add Negative numbers")
		void testAddNegative() {
			
			int expected = 0;
			int actual = mathUtil.add(-1, 1);
			assertEquals(expected, actual,"add method should add two numbers");
		}
	}
	
	@Test
	@DisplayName("Testing Mutiply method")
	void testMultiply() {
		testReporter.publishEntry("running "+testInfo.getDisplayName() + "with tags "+testInfo.getTags());
		assertAll(
				() -> assertEquals(4,mathUtil.multiply(2, 2)),
				() -> assertEquals(0,mathUtil.multiply(2, 0)),
				() -> assertEquals(-2,mathUtil.multiply(2, -1))
				);
	}
	
	
	//executes only when assumetrue is true
	@Test
	void testDivide() {

		boolean isServerUp = false;
		//assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(1, 0),"Divide by zero should throw exception");
	}
	
	//lazy assert using lambda
	@Test
	@Tag("Cirle")
	void testComputeCircleRadius() {
		System.out.println("running "+testInfo.getDisplayName() + "with tags "+testInfo.getTags());
		testReporter.publishEntry("running "+testInfo.getDisplayName() + "with tags "+testInfo.getTags());
		assertEquals(314.1592653589793,mathUtil.computeCircleArea(10),() -> "Method should return area of circle");
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method. Should not run now")
	void testDisabled() {
		fail("This test should be disabled");
	}
	

}
 