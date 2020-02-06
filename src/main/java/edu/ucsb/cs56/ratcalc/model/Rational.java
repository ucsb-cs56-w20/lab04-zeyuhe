package edu.ucsb.cs56.ratcalc.model;
/**
 * A class to represent a rational number with a numerator and denominator
 * 
 * @author P. Conrad for CS56 F16
 * 
 */

public class Rational {

	private int num;
	private int denom;

	/**
	 * greatest common divisor of a and b
	 * 
	 * @param a first number
	 * @param b second number
	 * @return gcd of a and b
	 */
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		else if (b == 0)
			return a;
		else
			return gcd(b % a, a);
	}

	public Rational() {
		this.num = 1;
		this.denom = 1;
	}

	public Rational(int num, int denom) {
		if (denom == 0) {
			throw new IllegalArgumentException("denominator may not be zero");
		}
		this.num = num;
		this.denom = denom;
		if (num != 0) {
			int gcd = Rational.gcd(num, denom);
			this.num /= gcd;
			this.denom /= gcd;
		}
	}

	public String toString() {
		if (denom == 1 || num == 0)
			return "" + num;
		return num + "/" + denom;
	}

	public int getNumerator() {
		return this.num;
	}

	public int getDenominator() {
		return this.denom;
	}

	public Rational times(Rational r) {
		return new Rational(this.num * r.num, this.denom * r.denom);
	}

	public static Rational product(Rational a, Rational b) {
		return new Rational(a.num * b.num, a.denom * b.denom);
	}

	public static int lcm(int a, int b){
		if (a==0 && b ==0) {
			throw new IllegalArgumentException("denominator may not be zero");
		}
		return (Math.abs( a * b)/(gcd(a, b))) ; 
	}

	public Rational plus(Rational r){
		Rational ans = new Rational((this.num * r.denom)+(r.num*this.denom), this.denom*r.denom);
		if (ans.num > 0 && ans.denom < 0) {
			ans.num *= -1;
			ans.denom *= -1;
		}
		return ans;
	}

	public static Rational sum(Rational a, Rational b){
		return a.plus(b);
	}

	public Rational minus(Rational r){
		r = r.times(new Rational(-1,1));
		return this.plus(r);
	}

	public static Rational difference(Rational a, Rational b){
		return a.minus(b);
	}

	public Rational reciprocalOf(){
		if (this.num ==0){
			throw new ArithmeticException("denominator may not be zero");
		}
		if (this.num < 0 && this.denom > 0) {
			this.num *= -1;
			this.denom *= -1;
		}
		Rational ans  = new Rational(this.denom, this.num);
		if(ans.denom<0){
			ans.denom *= -1;
			ans.num *= -1;
			
		}
		return ans;
	}

	public Rational dividedBy(Rational r) {
		r = r.reciprocalOf();
		return this.times(r);
	}

	public static Rational quotient(Rational a, Rational b){
		return a.dividedBy(b);
	}
	/**
	 * For testing getters.
	 * 
	 * @param args unused
	 */

	public static void main(String[] args) {
		Rational r = new Rational(-20, 25);
		var r2 = r.reciprocalOf();
		System.out.println("r.getNumerator()=" + r.getNumerator());
		System.out.println("r.getDenominator()=" + r.getDenominator());
	}



}
