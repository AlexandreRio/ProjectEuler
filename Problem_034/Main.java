import java.math.BigInteger;

public class Main {

  private static final long MAX_VALUE = 10000000;

  public static void main (String[] args) {
    long sum = 0;
    for (long i=3; i<MAX_VALUE; i++) {
      if (factorialOfDigit(i).longValue() == i) {
        sum += i;
        System.out.println(i);
      }
    }
    System.out.println("Sum " + sum);
  }

  private static BigInteger factorialOfDigit(long l) {
    BigInteger sum = new BigInteger("0");
    while (l > 0) {
      BigInteger tmp = new BigInteger(Long.toString(l%10));
      tmp = factorial(tmp);
      sum = sum.add(tmp);
      l /= 10;
    }
    return sum;
  }

  private static BigInteger factorial(BigInteger n) {
    if (n.toString().equals("0")) return BigInteger.ONE;
    else return n.multiply(factorial(n.subtract(BigInteger.ONE)));
  }

}
