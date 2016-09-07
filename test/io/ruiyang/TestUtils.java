/**
 * @author rui yang
 * Date: 07.09.2016
 */
package io.ruiyang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import io.ruiyang.exception.InvalidInputException;

import java.math.BigDecimal;

// utility function wrapper for test.
public class TestUtils {
	// three input values are the same.
	public static void determineTriangle_equilateralOrInvalid(BigDecimal i, Utils.TriangleType tType, boolean checkingException, String errorMsg){
		if(checkingException){
			determineThreeSidesWithInCorrectInput(i, i, i, tType, errorMsg);
		}
		else{
			determineThreeSidesWithCorrectInput(i, i, i, tType);
		}
	}
	
	// two out of three input values are the same. The input parameter j is the value of that two input with the same value.
	public static void determineTriangle_isoscelesOrInvalid(BigDecimal i, BigDecimal j, Utils.TriangleType tType, boolean checkingException, String errorMsg){
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
	public static void determineTriangle_scaleneOrInvalid(BigDecimal i, BigDecimal j, BigDecimal k, Utils.TriangleType tType, boolean checkingException, String errorMsg){
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
	
	public static void determineThreeSidesWithCorrectInput(BigDecimal i, BigDecimal j, BigDecimal k, Utils.TriangleType tType){
		try {
			assertEquals(Utils.determineTriangle(i, j, k), tType);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	public static void determineThreeSidesWithInCorrectInput(BigDecimal i, BigDecimal j, BigDecimal k, Utils.TriangleType tType, String errorMsg){
		try {
			assertEquals(Utils.determineTriangle(i, j, k), tType);
			fail();
		} catch (InvalidInputException e) {
			if(errorMsg != null) assertEquals(e.getMessage(), errorMsg);
		}
	}
}
