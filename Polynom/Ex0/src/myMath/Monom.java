
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	/**
	 * constructor for a monom with given coefficient and power
	 * @param a given coefficient
	 * @param b given power
	 */
	public Monom(double a, int b){
		if (b < 0) {
			throw new RuntimeException("power cant be nagative");
		}
		this.set_coefficient(a);
		this.set_power(b);
	}
	/**
	 * creating a monom according to a given monom
	 * @param ot the given monom
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************
	/**
	 * default constructor for monom
	 */
	public Monom () { //default constructor
		this.set_coefficient(0);
		this.set_power(0);
	}
	/**
	 * monom constructor that works according to a given String
	 * @param s the given string
	 */
	public Monom (String s) {
		if (!s.contains("X")) { //checking for "normal" number
			double temp2;
			try { //checking for problems in entry
				temp2 = Double.parseDouble(s);
			}
			catch (Exception e) {
				throw new RuntimeException ("Problem with entry");
			}
			this.set_coefficient(temp2); //setting the monom
			this.set_power(0);
			return;
		}
		String [] str = s.split("X"); //spliting the polynom for each element that builds it
		if (str[0].charAt(str[0].length()-1) != '*') { //checking for errors in entry string
			throw new RuntimeException ("Invalid entry");
		}
		str[0] = str[0].substring(0, str[0].length()-1); //setting the elements of the polynom and checking for errors in string
		try {
			this.set_coefficient(Double.parseDouble(str[0]));
		}
		catch (Exception e) {
			throw new RuntimeException ("Invalid entry " + str[0]);
		}
		String str2 = str[1].substring(1);
		try {
			this.set_power(Integer.parseInt(str2));
		}
		catch (Exception e) {
			throw new RuntimeException ("Invalid entry " + str[1]);
		}
	}
	/**
	 * getter for the monom coefficient
	 * @return the coefficient
	 */
	public double get_coefficient() {
		return this._coefficient;
	}
	/**
	 * getter for the monom power
	 * @return the power
	 */
	public int get_power() {
		return this._power;
	}
	/**
	 * calculating the monom f(x) value at a certain point for the monom
	 * @param x point to calculate the value
	 * @return the value of the monom at that point
	 */
	public double f(double x) { //value of Monom on f(x)
		return Math.pow(x, get_power()) * get_coefficient();
	}
	/**
	 * derivative ("Gozrim") this monom
	 */
	public void derivative () { //setting the Monom derivative
		int pow = get_power();
		this.set_power(get_power()-1); //new power
		this.set_coefficient(pow * this._coefficient); //new coefficient
	}
	/**
	 * adding a given monom to a certain monom to one if possible
	 * @param temp given monom
	 */
	public void add (Monom temp) { //adding to monoms to one
		if (temp == null) { //checking for errors
			System.err.println("null");
			return;
		}
		if (temp.get_power() == this.get_power()) {
			this.set_coefficient(this._coefficient + temp._coefficient);
		}
		else {
			System.err.println("cant be used as monom, polynom"); // checking for errors
		}
	}
	/**
	 * multiplying two monoms to one
	 * @param temp given monom to multiply with this monom
	 */
	public void multiply (Monom temp) { //multiplying two Monoms to one
		if (temp == null) { //checking for errors
			System.err.println("null");
			return;
		}
		this.set_coefficient(this.get_coefficient() * temp.get_coefficient()); //setting new elements
		this.set_power(this.get_power() + temp.get_power());
	}
	/**
	 * String representation for this monom
	 * @return the String representation for this monom
	 */
	public String toString() {
		return this._coefficient + "*X^" + this.get_power();
	}
	//****************** Private Methods and Data *****************
	/**
	 * setting a monom coefficient
	 * @param a given coefficient
	 */
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	/**
	 * setting a monom power
	 * @param p given power
	 */
	private void set_power(int p) {
		this._power = p;
	}
	
	private double _coefficient; // 
	private int _power; 
}
