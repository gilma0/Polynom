package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class polynomJunit {

	@Test
	void testAddPolynom_able() {
		Polynom test = new Polynom("5*X^3");
		Polynom tester = new Polynom ("6*X^2");
		test.add(tester);
		Polynom answer = new Polynom ("5*X^3+6*X^2");
		if (!test.equals(answer)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testAddMonom() {
		Polynom test = new Polynom("5*X^1");
		Monom tester = new Monom ("2*X^1");
		Polynom answer = new Polynom ("7*X^1");
		test.add(tester);
		if(!test.equals(answer)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testPolynom() {
		Polynom test = new Polynom();
		Monom tester = new Monom("1*X^1");
		test.add(tester);
		Polynom answer = new Polynom ("1*X^1");
		if(!test.equals(answer)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testPolynomString() {
		Polynom test = new Polynom ("5*X^2");
		Monom temp = new Monom ("5*X^2");
		Polynom answer = new Polynom();
		answer.add(temp);
		if(!test.equals(answer)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testF() {
		Polynom test = new Polynom ("5*X^1");
		if(test.f(2) != 10) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testSubstract() {
		Polynom test = new Polynom ("10*X^2");
		Polynom tester = new Polynom ("3*X^2");
		test.substract(tester);
		Polynom answer = new Polynom ("7*X^2");
		if (!test.equals(answer)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testIteretor() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
