package myMath;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

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
		Polynom test = new Polynom ("2*X^3");
		Polynom tester = new Polynom ("6*X^1");
		test.multiply(tester);
		Polynom answer = new Polynom ("12*X^4");
		if (!test.equals(answer)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testEqualsPolynom_able() {
		Polynom test = new Polynom ("5*X^1");
		Polynom tester = new Polynom();
		Monom temp = new Monom ("5*X^1");
		tester.add(temp);
		boolean answer = test.equals(tester);
		if (answer != true) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testIsZero() {
		Polynom test = new Polynom ("0*X^3-0*X^2");
		boolean tester = false;
		if(test.isZero() == tester) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testRoot() {
		Polynom test = new Polynom ("1*X^1");
		if (test.root(-1, 1, 0.5) > 0.5) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testCopy() {
		Polynom test = new Polynom ("2*X^3-3*X^1");
		if (!test.equals(test.copy())) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testDerivative() {
		Polynom test = new Polynom ("5*X^3");
		Polynom answer = new Polynom ("15*X^2");
		if (!answer.equals(test.derivative())) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testArea() {
		Polynom test = new Polynom ("1*X^1");
		if (test.area(1, 2, 0.0001) > 1.58 || test.area(1, 2, 0.0001) < 1.42) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testIteretor() {
		Polynom test = new Polynom ("5*X^3");
		Monom tester = new Monom ("5*X^3");
		Iterator<Monom> temp = test.iteretor();
		Monom answer = new Monom(temp.next());
		boolean answer2 = true;
		if (answer.get_coefficient() != tester.get_coefficient() || answer.get_power() != tester.get_power()) {
			answer2 = false;
		}
		if (answer2 == false) {
			fail("Not yet implemented");
		}
	}

}
