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
	BigDecimal BD_DOUBLE_MAX_VALUE = new BigDecimal(Double.MAX_VALUE);
	BigDecimal BD_DOUBLE_MIN_VALUE = new BigDecimal(Double.MIN_VALUE);
	

	// incorrect number of sides as input test.
	@Test
	public void determineTriangle_incorrectNumberOfSidesAsInputTest(){
		determineInputLength(new BigDecimal[]{}, 								 Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
		determineInputLength(new BigDecimal[]{ BD_N_ONE }, 						 Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
		determineInputLength(new BigDecimal[]{ BD_ONE, BD_ONE }, 				 Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
		determineInputLength(new BigDecimal[]{ BD_ONE, BD_ONE, BD_ONE, BD_ONE }, Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG);
	}
	
	public void determineInputLength(BigDecimal[] bdArray, String errorMsg){
		try {
			Utils.determineTriangle(bdArray); fail();
		} catch (InvalidInputException e) {
			assertEquals(e.getMessage(), errorMsg);
		}
	}
	
	// zero test.
	@Test
	public void determineTriangle_zeroTest(){
		determineTriangle_isoscelesOrInvalid(BD_ZERO,
				BD_ONE,
				Utils.TriangleType.INVALID,
				true, // invalid input, checking exception
				null);
	}
	
	// one negative value test.
	@Test
	public void determineTriangle_oneNegativeValueTest(){
		determineTriangle_isoscelesOrInvalid(BD_N_ONE, 
				BD_ONE, 
				Utils.TriangleType.INVALID,
				true,
				null);
	}
	
	// two negative values test.
	@Test
	public void determineTriangle_twoNegativeValuesTest(){
		determineTriangle_isoscelesOrInvalid(BD_ONE, 
				BD_N_ONE, 
				Utils.TriangleType.INVALID,
				true,
				null);
	}
	
	// three negative values test.
	@Test
	public void determineTriangle_threeNegativeValuesTest(){
		determineTriangle_equilateralOrInvalid(BD_N_ONE, 
				Utils.TriangleType.INVALID,
				true,
				null);
	}
	
	// invalid triangle test.
	@Test
	public void determineTriangle_invalidTriangleTest(){
		determineTriangle_isoscelesOrInvalid(BD_FIVE, 
				BD_TWO, 
				Utils.TriangleType.INVALID,
				false, // valid input, no need to check exception.
				null);
		
		determineTriangle_scaleneOrInvalid(BD_ONE, 
				BD_THREE, 
				BD_FIVE, 
				Utils.TriangleType.INVALID,
				false,
				null);
	}
	
	// equilateral test
	@Test
	public void determineTriangle_equilateralTest(){
		determineTriangle_equilateralOrInvalid(BD_ONE, 
				Utils.TriangleType.EQUILATERAL,
				false,
				null);
	}
	
	// isosceles test.
	@Test
	public void determineTriangle_isoscelesTest(){	
		determineTriangle_isoscelesOrInvalid(BD_ONE, 
				BD_TWO, 
				Utils.TriangleType.ISOSCELES,
				false,
				null);
	}

	// scalene test.
	@Test
	public void determineTriangle_scaleneTest(){
		determineTriangle_scaleneOrInvalid(BD_TWO,
				BD_THREE, 
				BD_FOUR, 
				Utils.TriangleType.SCALENE,
				false,
				null);	
	}

	
	// three input values are the same.
	public void determineTriangle_equilateralOrInvalid(BigDecimal i,
													   Utils.TriangleType tType,
													   boolean checkingException, String errorMsg){
		if(checkingException){
			determineThreeSidesWithInCorrectInput(i, i, i, tType, errorMsg);
		}
		else{
			determineThreeSidesWithCorrectInput(i, i, i, tType);
		}
	}
	
	// two out of three input values are the same. The input parameter j is the value of that two input with the same value.
	public void determineTriangle_isoscelesOrInvalid(BigDecimal i,
													 BigDecimal j, 
													 Utils.TriangleType tType, 
													 boolean checkingException, String errorMsg){
		
		if(checkingException){
			determineThreeSidesWithInCorrectInput(i, j, j, tType, errorMsg);
			determineThreeSidesWithInCorrectInput(j, i, j, tType, errorMsg);
			determineThreeSidesWithInCorrectInput(j, j, i, tType, errorMsg);
		}
		else{
			determineThreeSidesWithCorrectInput(i, j, j, tType);
			determineThreeSidesWithCorrectInput(j, i, j, tType);
			determineThreeSidesWithCorrectInput(j, j, i, tType);
		}
	}
	
	// three input values are identical.
	public void determineTriangle_scaleneOrInvalid(BigDecimal i, 
												   BigDecimal j, 
												   BigDecimal k, 
												   Utils.TriangleType tType, 
												   boolean checkingException, String errorMsg){
		
		if(checkingException){
			determineThreeSidesWithInCorrectInput(i, j, k, tType, errorMsg);
			determineThreeSidesWithInCorrectInput(i, k, j, tType, errorMsg);
			determineThreeSidesWithInCorrectInput(j, i, k, tType, errorMsg);
			
			determineThreeSidesWithInCorrectInput(j, k, i, tType, errorMsg);
			determineThreeSidesWithInCorrectInput(k, j, i, tType, errorMsg);
			determineThreeSidesWithInCorrectInput(k, i, j, tType, errorMsg);
		}
		else{
			determineThreeSidesWithCorrectInput(i, j, k, tType);
			determineThreeSidesWithCorrectInput(i, k, j, tType);
			determineThreeSidesWithCorrectInput(j, i, k, tType);
			
			determineThreeSidesWithCorrectInput(j, k, i, tType);
			determineThreeSidesWithCorrectInput(k, j, i, tType);
			determineThreeSidesWithCorrectInput(k, i, j, tType);
		}
	}
	
	public void determineThreeSidesWithCorrectInput(BigDecimal i, BigDecimal j, BigDecimal k, Utils.TriangleType tType){
		try {
			assertEquals(Utils.determineTriangle(i, j, k), tType);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	public void determineThreeSidesWithInCorrectInput(BigDecimal i, BigDecimal j, BigDecimal k, Utils.TriangleType tType, String errorMsg){
		try {
			assertEquals(Utils.determineTriangle(i, j, k), tType);
			fail();
		} catch (InvalidInputException e) {
			if(errorMsg != null) assertEquals(e.getMessage(), errorMsg);
		}
	}
	
}