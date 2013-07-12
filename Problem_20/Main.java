import java.math.BigInteger;

public class Main {

  public static void main (String[] args) {
    String s = factorial(new BigInteger("100")).toString();
    char[] digit = s.toCharArray();
    int sum = 0;
    for (int i=0; i<digit.length; i++) {
      sum += Character.getNumericValue(digit[i]);
    }
    System.out.println("Sum: " + sum);
  }

  public static BigInteger factorial(BigInteger n) {
    if (n.toString().equals("0")) return new BigInteger("1");
    else return n.multiply(factorial(n.subtract(new BigInteger("1"))));
  }
}
