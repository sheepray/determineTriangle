package io.ruiyang;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

	// invalid input test.
	@Test
	public void determineTriangle_invalidInput() {
		// one negative value test.
		assertEquals(Utils.determineTriangle(-1, 1, 1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(1, -1, 1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(1, 1, -1), Utils.TriangleType.INVALID);
		
		// two negative values test.
		assertEquals(Utils.determineTriangle(-1, -1, 1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(-1, 1, -1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(1, -1, -1), Utils.TriangleType.INVALID);

		// three negative values test.
		assertEquals(Utils.determineTriangle(-1, -1, -1), Utils.TriangleType.INVALID);

		// zero test.
		assertEquals(Utils.determineTriangle(0, 1, 1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(1, 0, 1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(1, 1, 0), Utils.TriangleType.INVALID);
		
		// incorrect number of sides
		assertEquals(Utils.determineTriangle(new double[]{4, 5, 6, 7}), Utils.TriangleType.INVALID);
	}
	
	// function correctness test.
	@Test
	public void determineTriangle_correctnessNormalVar(){
		// equilateral test.
		assertEquals(Utils.determineTriangle(1, 1, 1), Utils.TriangleType.EQUILATERAL);
		
		// isosceles test.
		assertEquals(Utils.determineTriangle(1, 2, 2), Utils.TriangleType.ISOSCELES);
		assertEquals(Utils.determineTriangle(2, 1, 2), Utils.TriangleType.ISOSCELES);
		assertEquals(Utils.determineTriangle(2, 2, 1), Utils.TriangleType.ISOSCELES);
		
		// scalene test.
		assertEquals(Utils.determineTriangle(2, 3, 4), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(2, 4, 3), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(3, 2, 4), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(3, 4, 2), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(4, 3, 2), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(4, 2, 3), Utils.TriangleType.SCALENE);

		// invalid triangle test.
		assertEquals(Utils.determineTriangle(1, 3, 5), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(1, 5, 3), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(3, 1, 5), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(3, 5, 1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(5, 1, 3), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(5, 3, 1), Utils.TriangleType.INVALID);
	}
}