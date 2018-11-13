package myMath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

import javax.xml.transform.Templates;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	// ********** add your code below ***********
	private ArrayList<Monom> polynom;
	private Comparator <Monom> sort = new Monom_Comperator();
	/**
	 * adding a polynom to a existing polynom
	 * @param p1 the given polynom
	 */
	public void add(Polynom_able p1){ //adding polynom to other polynom for each element
		Iterator <Monom> iter = p1.iteretor();
		while (iter.hasNext()) { 
			Monom temp = new Monom (iter.next()); 
			if (temp.get_coefficient() != 0) { //checking if there's no need to add
				this.add(temp);
			}
		}
	}
	/**
	 * adding a certain Monom to the polynom
	 * @param m1 given polynom
	 */
	public void add(Monom m1){ // adding momon to polynom
		if(m1.get_coefficient() == 0) { //checking if there's no need to add
			return;
		}
		if (this.polynom.isEmpty()) {
			this.polynom.add(m1);
			return;
		}
		Iterator <Monom> iter = this.polynom.iterator();
		while (iter.hasNext()) { // checking if this polynom has same power elemnt and combining them
			Monom temp = new Monom (iter.next());
			if (temp.get_power() == m1.get_power()) {
				iter.remove();
				temp.add(m1);
				this.polynom.add(temp);
				return;
			}
		}
		this.polynom.add(m1); //if there are no others with the same power its added as a unique element
	}
	/**
	 * default constructor for polynom type
	 */
	public Polynom () {//default constructor
		polynom = new ArrayList<Monom>();
	}
	/**
	 * String constructor for polynom
	 * @param s given String
	 */
	public Polynom (String s) {
		polynom = new ArrayList<Monom>();
		if (s == null || s == "" || s.contains(" ")) { //checking for errors in entry
			throw new RuntimeException ("wrong string");
		}
		for (int i = s.length()-1; i > 1; i--) { // going through the string and getting each element
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				String temp = s.substring(i+1, s.length());
				if (s.charAt(i) == '-') {
					temp = "-" + temp;
				}
				Monom toran = new Monom (temp);
				this.add(toran);
				s = s.substring(0,i);
			}
		}
		Monom toran = new Monom (s); //final (first) element
		this.add(toran);
	}
	/**
	 * testing the f(x) value at a certain x
	 * @param x the given point to check value of the polynom
	 * @return the value of the polynom at that point
	 */
	public double f (double x) { //calculating the polynom value for certain x
		Iterator <Monom> iter = this.polynom.iterator();
		double sum = 0;
		while (iter.hasNext()) {
			sum = sum + iter.next().f(x);
		}
		return sum;
	}
	/**
	 * subtracting a certain polynom with a given one
	 * @param p1 given polynom
	 */
	public void substract(Polynom_able p1){ //substracting this polynom with another one
			Iterator <Monom> iter2 = p1.iteretor();
			while (iter2.hasNext()) {
				Monom temp = new Monom (iter2.next());
				Monom temp2 = new Monom ((-1)*temp.get_coefficient(), temp.get_power()); //making each element of the entered polynom a -.
				this.add(temp2);
			}
	}
	/**
	 * Multiply two polynoms
	 * @param p1 the polynom you want to multiply on this polynom
	 */
	public void multiply(Polynom_able p1){
		Iterator <Monom> iter = this.iteretor();
		Iterator <Monom> iter2 = p1.iteretor();
		Polynom ans = new Polynom(); //answer polynom
		Monom temp = new Monom (iter.next());
		while (iter2.hasNext() || iter.hasNext()) { //checking if the the polynom is over
			if (!iter2.hasNext()) {
				iter2 = p1.iteretor();
				temp = iter.next();
			}
			Monom temp2 = new Monom (iter2.next()); //multiplying each element and adding them to the new polynom
			Monom answer = new Monom(temp.get_coefficient()*temp2.get_coefficient(), temp.get_power()+temp2.get_power());
			System.out.println(answer);
			ans.add(answer);
		}
		iter = this.iteretor();
		while (iter.hasNext()) {//clearing original polynom
			iter.next();
			iter.remove();
		}
		Iterator <Monom> iter3 = ans.iteretor(); //entering answer polynom to original
		while (iter3.hasNext()) {
			this.add(iter3.next());
		}
	}
	/**
	 * Test if this Polynom is logically equals to p1.
	 * @param p1 the polynom to compare with
	 * @return true if this polynom is equal to p1. false otherwise
	 */
	public boolean equals (Polynom_able p1){
		this.polynom.sort(sort); //sorting the polynom for easier checking
		Polynom a = new Polynom(); //making new polynom for entered one to work
		a.add(p1);
		a.polynom.sort(sort); //sorting entered polynom
		Iterator <Monom> iter = a.iteretor();
		Iterator <Monom> iterMain = this.iteretor();
		boolean answer = true;
		while (iter.hasNext()) { 
			if (iter.hasNext() && !iterMain.hasNext()) { //checking if one or the other are longer
				answer = false;
			}
			if (!iter.hasNext() && iterMain.hasNext()) {
				answer = false;
			}
			if (answer == false) {
				return false;
			}
			Monom temp = new Monom (iter.next());
			while (temp.get_coefficient() == 0) {
				temp = new Monom (iter.next());
			}
			Monom temp2 = new Monom (iterMain.next());
			while (temp2.get_coefficient() == 0) {
				temp2 = new Monom (iterMain.next());
			}
			if (temp.get_coefficient() != temp2.get_coefficient() || temp.get_power() != temp2.get_power()) { //checking each element if equals
				return false;
			}
		}
		return true;
	}
	/**
	 * Test if this Polynom is logically equals to 0.
	 * @return true if the polynom equal to 0, false otherwise.
	 */
	public boolean isZero(){
		if(this.polynom.isEmpty()) {
			return true;
		}
		Iterator <Monom> iter = this.polynom.iterator();
		while (iter.hasNext()) {
			Monom temp = new Monom (iter.next());
			if (temp.get_coefficient() != 0) {
				return false;
			}
		}
		return true;
	}
	/**
	 * test if the polynom has a root between x0 and x1 at eps precision
	 * @param x0 start point
	 * @param x1 end point
	 * @param eps epsilon precision
	 * @return the value of the polynom at the root according to the epsilon
	 */
	public double root(double x0, double x1, double eps) {
		double mid = (x0+x1)/2; //calculating mid
		if (Math.abs(this.f(mid)) <= eps) { //checking for answer
			return this.f(mid);
		}
		if ((this.f(x0) > 0 && this.f(mid) < 0) || (this.f(x0) < 0 && this.f(mid) > 0)) { //checking which side to check
			return root(x0,mid,eps);
		}
		else {
			return root(mid,x1,eps);
		}
	}

	/**
	 * deep copies a given polynom.
	 * @return the copied polynom.
	 */
	public Polynom_able copy(){ //deep copy of polynom for each element
		Polynom answer = new Polynom();
		Iterator <Monom> iter = this.iteretor();
		while (iter.hasNext()) { // getting each element
			Monom temp = new Monom (iter.next());
			answer.add(temp);
		}
		System.out.println(answer);
		return answer;
	}
	 /**
	 *  derivative ("Gozrim") a given polynom
	 * @return the polynom after the action ("Gazur")
	 */
	public Polynom_able derivative(){ //going through each element and doing derivative on it
		Iterator <Monom> iter = this.iteretor();
		Polynom answer = new Polynom();
		while (iter.hasNext()) { // building the answer polynom
			Monom temp = new Monom (iter.next());
			temp.derivative();
			answer.add(temp);
		}
		return answer;
	}
		/** 
		 * Calculating the area of this polynom within a certain given area
		 * @param x0 start point
		 * @param x1 end point
		 * @param eps epsilon for accuracy
		 * @return the calculated area
		 */
	public double area(double x0,double x1, double eps) {
		double sum = 0;
		Iterator <Monom> iter = this.polynom.iterator();
		for (double place = x0; place<=x1; place = place + eps) { //going through each rectangle and calculating its area
			double nowanswer = 0;
			while (iter.hasNext()) {
				nowanswer = nowanswer + (iter.next().f(place))*eps; //summing the areas of all rectangles
			}
			sum = sum + nowanswer;
			iter = this.polynom.iterator();
			nowanswer = 0;
		}
		return sum;
	}
		/** 
		 * creating a iterator for this polynom
		 * @return this polynom iterator
		 */
	public Iterator<Monom> iteretor(){
		Iterator <Monom> test = this.polynom.iterator();
		return test;
	}
	/**
	 * to string function for polynom printing.
	 * @return the polynom String representation
	 */
	public String toString() {
		System.out.println(this.polynom);
		return "";
	}
}
