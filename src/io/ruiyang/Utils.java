package io.ruiyang;

import java.util.Arrays;

// utility functions wrapper.
public class Utils{
	
	// type of triangle with its side included in a set T(a, b, c)
	public enum TriangleType{
		EQUILATERAL,	// a == b == c
		ISOSCELES,		// two members of T are equal, the rest one is not.
		SCALENE,		// a != b != c
		INVALID			// not a triangle, any (a + b) <= c or Math.abs(a - b) >= c
	};
	
	/**
	 * takes an array for the three side to determine what type of triangle they can form.
	 * It is the developer's responsibility to make sure the precision of values passed in.
	 * @param abc an array contains three sides.
	 * @return the type of triangle can be formed.
	 */
	public static TriangleType determineTriangle(double[] abc){
		if(abc == null || abc.length != 3){
			return TriangleType.INVALID;
		}
		
		// none of sides should be less or equal to 0
		for(int i = 0; i < abc.length; i++){
			if(abc[i] <= 0){
				return TriangleType.INVALID;
			}
		}
		
		Arrays.sort(abc); // sort array in ascending order.
		
		// the sum of two shortest sides should be bigger than the biggest side.
		if( abc[1] <= abc[2] - abc[0] ){
			return TriangleType.INVALID;
		}
		
		boolean abEqual = abc[0] == abc[1];
		boolean bcEqual = abc[1] == abc[2];
		
		if(abEqual && bcEqual) return TriangleType.EQUILATERAL;
		
		if(abEqual || bcEqual) return TriangleType.ISOSCELES;
		
		return TriangleType.SCALENE;
	}
	
	/**
	 * overloaded function to determine a triangle using three separate values.
	 * @param a 1st side.
	 * @param b 2nd side.
	 * @param c 3rd side.
	 * @return the type of triangle can be formed.
	 */
	public static TriangleType determineTriangle(double a, double b, double c){
		return determineTriangle(new double[]{a, b, c});
	}
}