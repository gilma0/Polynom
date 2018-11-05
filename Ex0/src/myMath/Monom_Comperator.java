package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	// ******** add your code below *********
	/**
	 * test which monom is "stronger" between two given
	 * @param a first monom
	 * @param b second monom
	 * @return the answer, -1 if a is stronger, 1 if b is stronger, 0 if they are of the same power.
	 */
	public int compare (Monom a, Monom b) { //checking which polynom is "stronger"
		if (a.get_power() > b.get_power()) {
			return -1;
		}
		if (a.get_power() < b.get_power()) {
			return 1;
		}
		return 0;
	}
}
