package myMath;

public class Test {
	/** 
	 * Test class for all the classes created
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 12;
		int b = 2;
		Monom dugma1 = new Monom (a,b); //first monom constructor
		System.out.println(dugma1);
		Monom dugma2 = new Monom (dugma1); //second monom constructor
		System.out.println(dugma2);
		Monom dugma3 = new Monom (); //third monom constructor
		System.out.println(dugma3);
		Monom dugma4 = new Monom ("5*X^3"); //fourth monom constructor
		System.out.println(dugma4); //monom to string
		System.out.println(dugma4.get_coefficient()); //monom coefficient getter
		System.out.println(dugma4.get_power()); //monom power getter
		System.out.println(dugma4.f(a)); //monom f function
		dugma1.derivative(); //monom derivative function
		System.out.println(dugma1);
		Monom forAdd = new Monom ("5*X^1");
		dugma1.add(forAdd); //monom add function
		System.out.println(dugma1);
		dugma1.multiply(dugma4); //monom multiply function
		System.out.println(dugma1);
		Polynom dugma5 = new Polynom (); //polynom first constructor
		dugma5.add(dugma2); //polynom add monom function
		System.out.println(dugma5);
		Polynom dugma6 = new Polynom ("5*X^4+3*X^2+5"); //polynom second constructor
		System.out.println(dugma6); //polynom to string function
		dugma6.add(dugma5); //polynom add polynom function
		System.out.println(dugma6);
		System.out.println(dugma6.f(2)); //polynom f(x) function
		dugma6.substract(dugma5); //polynom substract with another polynom function
		System.out.println(dugma6);
		dugma5.multiply(dugma6); //polynom multiply another polynom function
		System.out.println(dugma5);
		System.out.println(dugma5.equals(dugma6)); //polynom equals function
		System.out.println(dugma5.isZero()); //polynom is zero function
		Polynom dugma7 = new Polynom ("1*X^2-5*X^1");
		System.out.println(dugma7);
		System.out.println(dugma7.root(4, 6, 0.01)); //polynom root function
		System.out.println(dugma7.copy()); //polynom deep copy function
		System.out.println(dugma7.derivative()); //polynom derivative function
		System.out.println(dugma6);
		System.out.println(dugma6.area(0, 2, 0.0001)); //polynom area function
		Polynom test = new Polynom ("2*X^3-1*X^4");
		System.out.println(test.root(1, 4, 0.01));

	}

}
