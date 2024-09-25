import org.junit.Before;
import org.junit.Test;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestSimplePolynomial {

  private  Polynomial simplePolynomialUnderTest;

  @Before
  public void setUp() {
    simplePolynomialUnderTest = new SimplePolynomial();
  }

  @Test
  public void testAddTerm() {
    simplePolynomialUnderTest.addTerm(3,2);
    simplePolynomialUnderTest.addTerm(-2,1);
    simplePolynomialUnderTest.addTerm(5,0);

    assertEquals("3x^2-2x^1+5", simplePolynomialUnderTest.toString());
  }


  @Test
  public void testAddTermWithoutInitialElements(){

    simplePolynomialUnderTest.addTerm(3,2);
    assertEquals("3x^2", simplePolynomialUnderTest.toString());
  }


  @Test
  public void testEvaluatedValue(){
    simplePolynomialUnderTest.addTerm(3,4);
    simplePolynomialUnderTest.addTerm(-5,3);
    simplePolynomialUnderTest.addTerm(2,1);
    simplePolynomialUnderTest.addTerm(-4,0);
    assertEquals(40.0625,simplePolynomialUnderTest.evaluate(2.5),0.0);
  }


  @Test
  public void testAddition(){
    simplePolynomialUnderTest.addTerm(3,4);
    simplePolynomialUnderTest.addTerm(-5,3);
    simplePolynomialUnderTest.addTerm(2,1);
    simplePolynomialUnderTest.addTerm(-4,0);

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(2,3);
    anotherPolynomialToAdd.addTerm(2,2);
    anotherPolynomialToAdd.addTerm(4,0);

    assertEquals("3x^4-3x^3+2x^2+2x^1",simplePolynomialUnderTest.add(anotherPolynomialToAdd).toString());

   assertEquals("3x^4-5x^3+2x^1-4",simplePolynomialUnderTest.toString());
  }

  @Test
  public void testZeroPolynomial(){
    assertEquals("0",simplePolynomialUnderTest.toString());
  }

  @Test
  public void testMultiplyWithZero(){
    Polynomial polynomialToMultiply = new SimplePolynomial();
    polynomialToMultiply.addTerm(2,3);
    polynomialToMultiply.addTerm(2,2);
    polynomialToMultiply.addTerm(4,0);
    assertEquals("0",simplePolynomialUnderTest.multiply(polynomialToMultiply).toString());
  }


  @Test
  public void testEquals(){
    simplePolynomialUnderTest.addTerm(2,3);
    simplePolynomialUnderTest.addTerm(2,2);

    Polynomial anotherPolynomial = new SimplePolynomial();
    anotherPolynomial.addTerm(
        2,3);
    anotherPolynomial.addTerm(2,2);
    assertEquals(simplePolynomialUnderTest, anotherPolynomial);
  }

  @Test
  public void testNotEquals(){
    simplePolynomialUnderTest.addTerm(2,3);
    simplePolynomialUnderTest.addTerm(2,3);

    Polynomial anotherPolynomial = new SimplePolynomial();
    anotherPolynomial.addTerm(
            2,3);
    anotherPolynomial.addTerm(2,2);
    assertNotEquals(simplePolynomialUnderTest, anotherPolynomial);
  }


  @Test
  public void testDerivative(){
    simplePolynomialUnderTest.addTerm(3,4);
    simplePolynomialUnderTest.addTerm(-5,3);
    simplePolynomialUnderTest.addTerm(-2,1);
    simplePolynomialUnderTest.addTerm(-4,0);
    assertEquals("12x^3-15x^2-2",simplePolynomialUnderTest.derivative().toString());
  }

  @Test
  public void testToStringWithNegativeBeginning(){
    simplePolynomialUnderTest.addTerm(-3,4);
    simplePolynomialUnderTest.addTerm(-5,3);
    simplePolynomialUnderTest.addTerm(-2,1);
    simplePolynomialUnderTest.addTerm(-4,0);

    assertEquals("-3x^4-5x^3-2x^1-4",simplePolynomialUnderTest.toString());
  }

  @Test
  public void testWithPowerZero(){
    simplePolynomialUnderTest.addTerm(2,0);
    simplePolynomialUnderTest.addTerm(5,0);
    assertEquals("7",simplePolynomialUnderTest.toString());
  }

  @Test
  public void testDerivativeOfConstant(){
    simplePolynomialUnderTest.addTerm(2,0);
    assertEquals("0",simplePolynomialUnderTest.derivative().toString());
  }


}
