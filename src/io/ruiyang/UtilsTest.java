package io.ruiyang;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

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
	}
	
	@Test
	public void determineTriangle_correctness(){
		assertEquals(Utils.determineTriangle(1, 1, 1), Utils.TriangleType.EQUILATERAL);
		
		assertEquals(Utils.determineTriangle(1, 2, 2), Utils.TriangleType.ISOSCELES);
		assertEquals(Utils.determineTriangle(2, 1, 2), Utils.TriangleType.ISOSCELES);
		assertEquals(Utils.determineTriangle(2, 2, 1), Utils.TriangleType.ISOSCELES);
		
		assertEquals(Utils.determineTriangle(2, 3, 4), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(2, 4, 3), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(3, 2, 4), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(3, 4, 2), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(2, 3, 4), Utils.TriangleType.SCALENE);
		assertEquals(Utils.determineTriangle(2, 4, 3), Utils.TriangleType.SCALENE);

		assertEquals(Utils.determineTriangle(1, 3, 5), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(1, 5, 3), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(3, 1, 5), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(3, 5, 1), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(5, 1, 3), Utils.TriangleType.INVALID);
		assertEquals(Utils.determineTriangle(5, 3, 1), Utils.TriangleType.INVALID);
	}

}