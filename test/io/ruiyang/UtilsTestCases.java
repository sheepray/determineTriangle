/**
 * @author rui yang
 * Date: 07.09.2016
 */
package io.ruiyang;

import static org.junit.Assert.*;

import io.ruiyang.exception.InvalidInputException;

import java.math.BigDecimal;

import org.junit.Test;

// Utils.java test cases.
public class UtilsTestCases {
	// initialize some constant BD values.
	BigDecimal BD_N_ONE = new BigDecimal("-1");
	BigDecimal BD_ZERO = new BigDecimal("0");
	BigDecimal BD_ONE = new BigDecimal("1");
	BigDecimal BD_TWO = new BigDecimal("2");
	BigDecimal BD_THREE = new BigDecimal("3");
	
	BigDecimal BD_FOUR = new BigDecimal("4");
	BigDecimal BD_FIVE = new BigDecimal("5");
	BigDecimal BD_DOUBLE_MAX_VALUE = new BigDecimal( Double.MAX_VALUE );
	BigDecimal BD_DOUBLE_MIN_VALUE = new BigDecimal( -Double.MAX_VALUE );	

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
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_ZERO,
				BD_ONE,
				Utils.TriangleType.INVALID,
				true, // invalid input, checking exception
				null);
	}
	
	// one negative value test.
	@Test
	public void determineTriangle_oneNegativeValueTest(){
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_N_ONE, 
				BD_ONE, 
				Utils.TriangleType.INVALID,
				true,
				null);
		
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_DOUBLE_MIN_VALUE, 
				BD_DOUBLE_MAX_VALUE, 
				Utils.TriangleType.INVALID,
				true,
				null);
	}
	
	// two negative values test.
	@Test
	public void determineTriangle_twoNegativeValuesTest(){
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_ONE, 
				BD_N_ONE, 
				Utils.TriangleType.INVALID,
				true,
				null);
		
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_DOUBLE_MAX_VALUE, 
				BD_DOUBLE_MIN_VALUE, 
				Utils.TriangleType.INVALID,
				true,
				null);
	}
	
	// three negative values test.
	@Test
	public void determineTriangle_threeNegativeValuesTest(){
		TestUtils.determineTriangle_equilateralOrInvalid(BD_N_ONE, 
				Utils.TriangleType.INVALID,
				true,
				null);
		
		TestUtils.determineTriangle_equilateralOrInvalid(BD_DOUBLE_MIN_VALUE, 
				Utils.TriangleType.INVALID,
				true,
				null);
	}
	
	// invalid triangle test.
	@Test
	public void determineTriangle_invalidTriangleTest(){
		// two sides
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_FIVE, 
				BD_TWO, 
				Utils.TriangleType.INVALID,
				false, // valid input, no need to check exception.
				null);
		
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_DOUBLE_MAX_VALUE, 
				BD_DOUBLE_MAX_VALUE.divide(BD_TWO), 
				Utils.TriangleType.INVALID,
				false, // valid input, no need to check exception.
				null);
		
		// three sides
		TestUtils.determineTriangle_scaleneOrInvalid(BD_ONE, 
				BD_THREE, 
				BD_FIVE, 
				Utils.TriangleType.INVALID,
				false,
				null);
		
		TestUtils.determineTriangle_scaleneOrInvalid( BD_ONE, 
				BD_DOUBLE_MAX_VALUE.subtract( BD_THREE ), 
				BD_DOUBLE_MAX_VALUE.subtract( BD_FIVE ), 
				Utils.TriangleType.INVALID,
				false,
				null);
	}
	
	// equilateral test
	@Test
	public void determineTriangle_equilateralTest(){
		TestUtils.determineTriangle_equilateralOrInvalid(BD_ONE, 
				Utils.TriangleType.EQUILATERAL,
				false,
				null);
		
		TestUtils.determineTriangle_equilateralOrInvalid(BD_DOUBLE_MAX_VALUE, 
				Utils.TriangleType.EQUILATERAL,
				false,
				null);
	}
	
	// isosceles test.
	@Test
	public void determineTriangle_isoscelesTest(){	
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_ONE, 
				BD_TWO, 
				Utils.TriangleType.ISOSCELES,
				false,
				null);
		
		TestUtils.determineTriangle_isoscelesOrInvalid(BD_DOUBLE_MAX_VALUE.subtract( BD_ONE ), 
				BD_DOUBLE_MAX_VALUE.subtract( BD_TWO ), 
				Utils.TriangleType.ISOSCELES,
				false,
				null);
	}

	// scalene test.
	@Test
	public void determineTriangle_scaleneTest(){
		TestUtils.determineTriangle_scaleneOrInvalid( BD_TWO,
				BD_THREE,
				BD_FOUR, 
				Utils.TriangleType.SCALENE,
				false,
				null);
		
		TestUtils.determineTriangle_scaleneOrInvalid( BD_DOUBLE_MAX_VALUE.subtract( BD_TWO ),
				BD_DOUBLE_MAX_VALUE.subtract( BD_THREE ),
				BD_DOUBLE_MAX_VALUE.subtract( BD_FOUR ), 
				Utils.TriangleType.SCALENE,
				false,
				null);
	}
}