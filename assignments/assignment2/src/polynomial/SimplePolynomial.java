package polynomial;

import java.util.ArrayList;
import java.util.List;

public class SimplePolynomial implements Polynomial{

  private final List<Integer> polynomialCoefficients;

  public SimplePolynomial(){
    polynomialCoefficients = new ArrayList<>();
  }


  @Override
  public Polynomial add(Polynomial other) {
    Polynomial resultAfterAdding = new SimplePolynomial();
    int maxDegree = Math.max(this.getDegree(), other.getDegree());
    for(int i=0;i<=maxDegree;i++){
      int sum = this.getCoefficient(i) + other.getCoefficient(i);
      resultAfterAdding.addTerm(sum, i);
    }
    return resultAfterAdding;
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    Polynomial resultAfterMultiplying = new SimplePolynomial();
    for(int i=0;i<=this.getDegree();i++){
      for(int j=0;j<=other.getDegree();j++){
        int product = this.getCoefficient(i) * other.getCoefficient(j);
        resultAfterMultiplying.addTerm(product, i+j);
      }
    }
    return resultAfterMultiplying;
  }

  @Override
  public Polynomial derivative() {
    // TODO: recheck this
    Polynomial resultAfterDerivative = new SimplePolynomial();
    for(int i=1;i<=this.getDegree();i++){
      int derivativeCoefficient = this.getCoefficient(i) * i;
      resultAfterDerivative.addTerm(derivativeCoefficient, i-1);
    }
    return resultAfterDerivative;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if(power<0){
      throw new IllegalArgumentException("Power cannot be negative");
    }

    if(power==polynomialCoefficients.size()) {
      polynomialCoefficients.add(coefficient);
    }
    else if(power< polynomialCoefficients.size()){
      polynomialCoefficients.set(power, polynomialCoefficients.get(power)+coefficient);
    }
    else{
      for(int i= polynomialCoefficients.size();i<power;i++){
        polynomialCoefficients.add(0);
      }
      polynomialCoefficients.add(coefficient);
    }
  }

  @Override
  public int getDegree() {
    if (polynomialCoefficients.isEmpty()) {
      return 0;
    }
    return polynomialCoefficients.size() - 1;
  }

  @Override
  public double evaluate(double x) {
    double evaluatedValue = 0;
    for (int i = 0; i <= this.getDegree(); i++) {
      evaluatedValue += polynomialCoefficients.get(i) * Math.pow(x, i);
    }
    return evaluatedValue;
  }

  @Override
  public int getCoefficient(int power) {
    if(power<0 || power> this.getDegree()){
      return 0;
    }
    return polynomialCoefficients.get(power);
  }

  @Override
  public boolean equals(Object obj) {
    // TODO: recheck this
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SimplePolynomial that = (SimplePolynomial) obj;
    return polynomialCoefficients.equals(that.polynomialCoefficients);
  }

  @Override
  public int hashCode() {
    // TODO: recheck this
    return polynomialCoefficients.hashCode();
  }

  @Override
  public String toString(){
    if(polynomialCoefficients.isEmpty()){
      return "0";
    }
    StringBuilder polynomialAsString = new StringBuilder();
    for (int i =this.getDegree();i>=0;i--){
      int coefficient = polynomialCoefficients.get(i);
      if(coefficient==0){
        continue;
      }
      if(coefficient>0 && i!=this.getDegree()){
        polynomialAsString.append("+");
      }

      polynomialAsString.append(coefficient);
      if(i>0){
        polynomialAsString.append("x^").append(i);
      }
    }
    return polynomialAsString.toString();
  }
}
