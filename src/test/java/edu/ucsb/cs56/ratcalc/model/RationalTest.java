package edu.ucsb.cs56.ratcalc.model;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1;
    private Rational r_4_7;
    private Rational r_4_13 ;


    @Before
    public void setUp() {
        r_5_15 = new Rational(5, 15);
        r_24_6 = new Rational(24, 6);
        r_3_7 = new Rational(3, 7);
        r_13_4 = new Rational(13, 4);
        r_20_25 = new Rational(20, 25);
        r_0_1 = new Rational(0, 1);
        r_4_7 = new Rational(4,7);
        r_4_13 = new Rational(4,13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
        Rational r = new Rational(1, 0);
    }

    @Test
    public void test_getNumerator_20_25() {
        assertEquals(4, r_20_25.getNumerator());
    }

    @Test
    public void test_getNumerator_13_4() {
        assertEquals(13, r_13_4.getNumerator());
    }

    @Test
    public void test_getDenominator_20_25() {
        assertEquals(5, r_20_25.getDenominator());
    }

    @Test
    public void test_getDenominator_13_4() {
        assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
        assertEquals("1/3", r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
        assertEquals("4", r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
        assertEquals("3/7", r_3_7.toString());
    }

    @Test
    public void test_toString_20_25() {
        assertEquals("4/5", r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
        assertEquals("0", r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
        assertEquals(5, Rational.gcd(5, 15));
    }

    @Test
    public void test_gcd_15_5() {
        assertEquals(5, Rational.gcd(15, 5));
    }

    @Test
    public void test_gcd_24_6() {
        assertEquals(6, Rational.gcd(24, 6));
    }

    @Test
    public void test_gcd_17_5() {
        assertEquals(1, Rational.gcd(17, 5));
    }

    @Test
    public void test_gcd_1_1() {
        assertEquals(1, Rational.gcd(1, 1));
    }

    @Test
    public void test_gcd_20_25() {
        assertEquals(5, Rational.gcd(20, 25));
    }

    @Test
    public void test_rational_m10_m5() {
        Rational r = new Rational(-10, -5);
        assertEquals("2", r.toString());
    }

    @Test
    public void test_rational_m5_6() {
        Rational r = new Rational(-5, 6);
        assertEquals("-5/6", r.toString());
    }

    @Test
    public void test_rational_7_m8() {
        Rational r = new Rational(7, -8);
        assertEquals("-7/8", r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
        Rational r = r_5_15.times(r_3_7);
        assertEquals("1/7", r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
        Rational r = r_3_7.times(r_13_4);
        assertEquals("39/28", r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
        Rational r_m3_1 = new Rational(-3, 1);
        Rational r_1_m3 = new Rational(1, -3);
        Rational r = r_m3_1.times(r_1_m3);
        assertEquals("1", r.toString());
    }

    @Test
    public void test_product_of_r_5_15_and_r_3_7() {
        Rational r = Rational.product(r_5_15, r_3_7);
        assertEquals("1/7", r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
        Rational r = Rational.product(r_3_7, r_13_4);
        assertEquals("39/28", r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
        Rational r_m3_1 = new Rational(-3, 1);
        Rational r_1_m3 = new Rational(1, -3);
        Rational r = Rational.product(r_m3_1, r_1_m3);
        assertEquals("1", r.toString());
    }

    // these are the tests for the lcm
    @Test
    public void test_lcm_3_7() {
        assertEquals(21, Rational.lcm(3,7));
    }
    @Test
    public void test_lcm_24_6() {
        assertEquals(24, Rational.lcm(24,6));
    }
    @Test
    public void test_lcm_1_6() {
        assertEquals(6, Rational.lcm(1,6));
    }

    //these are the test for the plus method
    @Test
    public void test_plus_3_7_1_7(){
        assertEquals("4/7", (r_3_7.plus(new Rational(1,7))).toString());
    }
    @Test
    public void test_plus_3_7_1_6(){
        assertEquals("25/42", (r_3_7.plus(new Rational(1,6))).toString());
    }
    @Test
    public void test_plus_3_7_5_13(){
        assertEquals("74/91", (r_3_7.plus(new Rational(5,13))).toString());
    }
    //these are the test for the sum 
    @Test
    public void test_sum_3_7_4_13(){
        assertEquals("67/91", (Rational.sum(r_3_7, r_4_13)).toString());
    }
    @Test
    public void test_sum_0_1_4_7(){
        assertEquals("4/7", (Rational.sum(r_0_1, r_4_7)).toString());
    }
    @Test
    public void test_sum_5_15_13_4(){
        assertEquals("43/12", (Rational.sum(r_5_15, r_13_4)).toString());
    }
    // for minus
    @Test
    public void test_minus_5_15_13_4(){
        assertEquals("-35/12", (r_5_15.minus(new Rational(13,4))).toString());
    }
    @Test //need to change the format of negative
    public void test_minus_0_1_13_4(){
        assertEquals("-13/4", (r_0_1.minus(new Rational(13,4))).toString());
    }
    @Test
    public void test_minus_0_1_0_1(){
        assertEquals("0", ((r_0_1.minus(new Rational(0,1))).toString()));
    }

    // for difference
    @Test
    public void test_diff_5_15_13_4(){
        assertEquals("-35/12", (Rational.difference(r_5_15,r_13_4)).toString());
    }
    @Test //need to change the format of negative
    public void test_diff_0_1_13_4(){
        assertEquals("-13/4", (Rational.difference(r_0_1,r_13_4)).toString());
    }
    @Test
    public void test_diff_0_1_0_1(){
        assertEquals("0", ((Rational.difference(r_0_1,r_0_1))).toString());
    }

    //recipro
    @Test(expected = ArithmeticException.class)
    public void test_rece_0_1(){
        r_0_1.reciprocalOf();
    }
    @Test
    public void test_rece_m20_25(){
        Rational r_m20_25 = new Rational(-20, 25);
        
        assertEquals("-5/4", r_m20_25.reciprocalOf().toString());
    }
    @Test
    public void test_13_4(){
        assertEquals("4/13", (r_13_4.reciprocalOf()).toString());
    }
    @Test
    public void test_4_7(){
        assertEquals("7/4", (r_4_7.reciprocalOf()).toString());
    }

    @Test
    public void test_div_4_7_13_4(){
        assertEquals("16/91", ((r_4_7.dividedBy(r_13_4)).toString()));
    }

    @Test(expected = ArithmeticException.class)
    public void test_div_13_4_0_1(){
        r_13_4.dividedBy(r_0_1);
    }
    @Test
    public void test_div_0_1_13_4(){
        assertEquals("0", r_0_1.dividedBy(r_13_4).toString());
    }

    @Test
    public void test_quot_4_7_13_4(){
        assertEquals("16/91", (Rational.quotient(r_4_7,r_13_4).toString()));
    }

    @Test(expected = ArithmeticException.class)
    public void test_quot_13_4_0_1(){
        Rational.quotient(r_13_4,r_0_1);
    }
    @Test
    public void test_quot_0_1_13_4(){
        assertEquals("0", Rational.quotient(r_0_1,r_13_4).toString());
    }







}
