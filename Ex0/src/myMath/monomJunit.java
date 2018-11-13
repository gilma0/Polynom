package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class monomJunit {

	@Test
	void testMonomDoubleInt() {
		int a = 1;
		double b = 2;
		Monom test = new Monom (b,a);
		if (test.get_power() != 1 || test.get_coefficient() != 2) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testMonomMonom() {
		Monom temp = new Monom(2,1);
		Monom test = new Monom(temp);
		if(test.get_coefficient() != 2 || test.get_power() != 1) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testMonomString() {
		fail("Not yet implemented");
	}

	@Test
	void testGet_coefficient() {
		fail("Not yet implemented");
	}

	@Test
	void testGet_power() {
		fail("Not yet implemented");
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
