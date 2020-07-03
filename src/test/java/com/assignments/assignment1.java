package com.assignments;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.internetapp.tests.Calculator;

public class assignment1 {
	
	
	@DataProvider( name="numbers" ) // Item 2, Data providers
	public Object[][] numbers() {
		return new Object[][] {
			{1, 2},
			{2, 1},
			{1, 1}
		};
	}
	
	
	@Test(groups = { "exp" }, dataProvider = "numbers")
	public void testExponent(int num1, int num2) {
		System.out.println("\nRunning Test -> testExponent with data providers; Thread: " +Thread.currentThread().getId());
		double result = Calculator.exp(num1, num2);
		Assert.assertNotEquals(result, 1);
		Reporter.log(String.format("TestNG Assignment -> testExponent assertion passed for inputs %d, %d" , num1, num2), true);
	}
	
	
	@Test(groups = { "sum" })
	@Parameters({ "number1", "number2" })
	public void testAdd(int num1, int num2) {
		System.out.println("\nRunning Test -> testAdd; Thread: " +Thread.currentThread().getId());
		int result = Calculator.add(num1, num2);
		Assert.assertEquals(result, (num1 + num2));
		Reporter.log(String.format("TestNG Assignment -> testAdd assertion passed for inputs %d, %d" , num1, num2), true);
	}
	
	@Test(groups = { "product" })
	@Parameters({ "number1", "number2" })
	public void testMultiply(int num1, int num2) {
		System.out.println("\nRunning Test -> testMultiply; Thread: " +Thread.currentThread().getId());
		int result = Calculator.mul(num1, num2);
		Assert.assertTrue(result == (num1 * num2));
		Reporter.log(String.format("TestNG Assignment -> testMultiply assertion passed for inputs %d, %d" , num1, num2), true);
	}
	
	@Test(groups = { "div" })
	@Parameters({ "number1", "number2" })
	public void testDivide(int num1, int num2) {
		System.out.println("\nRunning Test -> testDivide with parameters; Thread: " +Thread.currentThread().getId());
		int result = Calculator.divInt(num1, num2);
		Assert.assertFalse(result != (num1 / num2));
		Reporter.log(String.format("TestNG Assignment -> testDivide assertion passed for inputs %d, %d" , num1, num2), true);
	}
	
// ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
	@Test(groups = { "sum" }, dataProvider = "numbers")
	public void testSub(int num1, int num2) {
		System.out.println("\nRunning Test -> testSub; Thread: " +Thread.currentThread().getId());
		int result = Calculator.sub(num1, num2);
		Assert.assertEquals(result, (num1 - num2));
		Reporter.log(String.format("TestNG Assignment -> testSub assertion passed for inputs %d, %d" , num1, num2), true);
	}
	
	@Test(groups = { "div" }, dataProvider = "numbers")
	public void testRealDivide(int num1, int num2) {
		System.out.println("\nRunning Test -> testRealDivide; Thread: " +Thread.currentThread().getId());
		double result = Calculator.divReal(num1, num2);
		Assert.assertNotEquals(result, (0));
		Reporter.log(String.format("TestNG Assignment -> testRealDivide assertion passed for inputs %d, %d" , num1, num2), true);
	}
	

	@Test(groups = { "div" }, dataProvider = "numbers")
	public void testMod(int num1, int num2) {
		System.out.println("\nRunning Test -> testMod; Thread: " +Thread.currentThread().getId());
		int result = Calculator.mod(num1, num2);
		Assert.assertEquals(result, (num1 % num2));
		Reporter.log(String.format("TestNG Assignment -> testMod assertion passed for inputs %d" , num1, num2), true);
	}
	

	@Test(groups = { "div" })
	@Parameters({ "number1" })
	public void testInverse(int num1) {
		System.out.println("\nRunning Test -> testInverse; Thread: " +Thread.currentThread().getId());
		double result = Calculator.inverse(num1);
		Assert.assertNotEquals(result, (1/num1));
		Reporter.log(String.format("TestNG Assignment -> testInverse assertion passed for inputs %d" , num1), true);
	}

	@Test(groups = { "product" })
	@Parameters({ "number1" })
	public void testNegated(int num1) {
		System.out.println("\nRunning Test -> testNegated; Thread: " +Thread.currentThread().getId());
		int result = Calculator.negate(num1);
		Assert.assertEquals(result, ((-1) * num1));
		Reporter.log(String.format("TestNG Assignment -> testNegated assertion passed for inputs %d" , num1), true);
	}
	
	
	
}
