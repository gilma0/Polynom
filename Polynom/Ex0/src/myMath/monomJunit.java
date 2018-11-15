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
		Monom test = new Monom();
		if(test.get_coefficient() != 0 || test.get_power() != 0) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testMonomString() {
		Monom test = new Monom ("2*X^3");
		if (test.get_coefficient() != 2 || test.get_power() != 3) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testGet_coefficient() {
		Monom test = new Monom (2,3);
		if (test.get_coefficient() != 2) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testGet_power() {
		Monom test = new Monom(2,3);
		if (test.get_power() != 3) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testF() {
		Monom test = new Monom (1,1);
		if (test.f(3) != 3) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testDerivative() {
		Monom test = new Monom (2,2);
		test.derivative();
		if (test.get_coefficient() != 4 || test.get_power() != 1) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testAdd() {
		Monom test = new Monom(2,3);
		Monom test2 = new Monom(5,3);
		test.add(test2);
		if (test.get_coefficient() != 7 || test.get_power() != 3) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testMultiply() {
		Monom test = new Monom(2,1);
		Monom test2 = new Monom(3,2);
		test.multiply(test2);
		if (test.get_coefficient() != 6 || test.get_power() != 3) {
			fail("Not yet implemented");
		}
	}

}
