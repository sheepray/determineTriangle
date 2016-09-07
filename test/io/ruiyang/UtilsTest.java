package io.ruiyang;

import static org.junit.Assert.*;

import io.ruiyang.exception.InvalidInputException;

import java.math.BigDecimal;

import org.junit.Test;

public class UtilsTest {
	// initialize some constant BD values.
	BigDecimal BD_N_ONE = new BigDecimal("-1");
	BigDecimal BD_ZERO = new BigDecimal("0");
	BigDecimal BD_ONE = new BigDecimal("1");
	BigDecimal BD_TWO = new BigDecimal("2");
	BigDecimal BD_THREE = new BigDecimal("3");
	
	BigDecimal BD_FOUR = new BigDecimal("4");
	BigDecimal BD_FIVE = new BigDecimal("5");

	// invalid input test.
	@Test
	public void determineTriangle_invalidInput() {
		
		// incorrect number of sides as input test.
		try {
			Utils.determineTriangle(new BigDecimal[]{}); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
		}
		
		try{
			Utils.determineTriangle(new BigDecimal[]{ BD_N_ONE }); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
		}
		
		try{
			Utils.determineTriangle(new BigDecimal[]{ BD_ONE, BD_ONE }); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
		}
		
		try{
			Utils.determineTriangle(new BigDecimal[]{ BD_ONE, BD_ONE, BD_ONE, BD_ONE }); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
		}
		
		// one negative value test.
		try {
			Utils.determineTriangle(BD_N_ONE, BD_ONE, BD_ONE); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), ("Expecting positive value at 1 side."));
		}
		
		try{
			Utils.determineTriangle(BD_ONE, BD_N_ONE, BD_ONE); fail();
		}
		catch(InvalidInputException e){
			assertEquals(e.getMessage(), ("Expecting positive value at 2 side."));
		}
		
		try{
			Utils.determineTriangle(BD_ONE, BD_ONE, BD_N_ONE); fail();
		}
		catch(InvalidInputException e){
			assertEquals(e.getMessage(), ("Expecting positive value at 3 side."));
		}
		
		// zero test.
		try {
			Utils.determineTriangle(BD_ZERO, BD_ONE, BD_ONE); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), ("Expecting positive value at 1 side."));
		}
		
		try{
			Utils.determineTriangle(BD_ONE, BD_ZERO, BD_ONE); fail();
		}
		catch(InvalidInputException e){
			assertEquals(e.getMessage(), ("Expecting positive value at 2 side."));
		}
		
		try{
			Utils.determineTriangle(BD_ONE, BD_ONE, BD_ZERO); fail();
		}
		catch(InvalidInputException e){
			assertEquals(e.getMessage(), ("Expecting positive value at 3 side."));
		}
		
		// two negative values test.
		try {
			Utils.determineTriangle(BD_N_ONE, BD_N_ONE, BD_ONE); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), ("Expecting positive value at 1 side."));
		}
		
		try {
			Utils.determineTriangle(BD_N_ONE, BD_ONE, BD_N_ONE); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), ("Expecting positive value at 1 side."));
		}
		
		try {
			Utils.determineTriangle(BD_ONE, BD_N_ONE, BD_N_ONE); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), ("Expecting positive value at 2 side."));
		}

		// three negative values test.
		try {
			Utils.determineTriangle(BD_N_ONE, BD_N_ONE, BD_N_ONE); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), ("Expecting positive value at 1 side."));
		}
		
	}
	
	// function correctness test.
	@Test
	public void determineTriangle_correctnessNormalVar(){
		
		// equilateral test.
		try {
			assertEquals(Utils.determineTriangle(BD_ONE, BD_ONE, BD_ONE), Utils.TriangleType.EQUILATERAL);
		} catch (InvalidInputException e) {
			fail();
		}
		
		// isosceles test.
		try {
			assertEquals(Utils.determineTriangle(BD_ONE, BD_TWO, BD_TWO), Utils.TriangleType.ISOSCELES);
		} catch (InvalidInputException e) {
			fail();
		}

		try {
			assertEquals(Utils.determineTriangle(BD_TWO, BD_ONE, BD_TWO), Utils.TriangleType.ISOSCELES);
		} catch (InvalidInputException e) {
			fail();
		}
		
		try {
			assertEquals(Utils.determineTriangle(BD_TWO, BD_TWO, BD_ONE), Utils.TriangleType.ISOSCELES);
		} catch (InvalidInputException e) {
			fail();
		}
		
		// scalene test.
		try {
			assertEquals(Utils.determineTriangle(BD_TWO, BD_THREE, BD_FOUR), Utils.TriangleType.SCALENE);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_TWO, BD_FOUR, BD_THREE), Utils.TriangleType.SCALENE);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_THREE, BD_TWO, BD_FOUR), Utils.TriangleType.SCALENE);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_THREE, BD_FOUR, BD_TWO), Utils.TriangleType.SCALENE);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_FOUR, BD_THREE, BD_TWO), Utils.TriangleType.SCALENE);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_FOUR, BD_TWO, BD_THREE), Utils.TriangleType.SCALENE);
		} catch (InvalidInputException e) {
			fail();
		}

		// invalid triangle test.
		try {
			assertEquals(Utils.determineTriangle(BD_ONE, BD_THREE, BD_FIVE), Utils.TriangleType.INVALID);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_ONE, BD_FIVE, BD_THREE), Utils.TriangleType.INVALID);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_THREE, BD_ONE, BD_FIVE), Utils.TriangleType.INVALID);
		} catch (InvalidInputException e1) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_THREE, BD_FIVE, BD_ONE), Utils.TriangleType.INVALID);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_FIVE, BD_ONE, BD_THREE), Utils.TriangleType.INVALID);
		} catch (InvalidInputException e) {
			fail();
		}
		try {
			assertEquals(Utils.determineTriangle(BD_FIVE, BD_THREE, BD_ONE), Utils.TriangleType.INVALID);
		} catch (InvalidInputException e) {
			fail();
		}
	}
}