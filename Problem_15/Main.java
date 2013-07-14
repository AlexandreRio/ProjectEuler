import java.math.BigInteger;

/**
 * This problem is purely mathematical, it refers to counting lattice paths,
 * the solution is (2n)!/n!² with n the width of the square.
 *
 */
public class Main {

  public static void main (String[] args) {
    BigInteger num = factorial(new BigInteger("40"));
    BigInteger denum = factorial(new BigInteger("20"));
    denum = denum.multiply(denum);
    System.out.println(num.divide(denum).toString());
  }

  public static BigInteger factorial(BigInteger n) {
    if (n.toString().equals("0")) return new BigInteger("1");
    else return n.multiply(factorial(n.subtract(new BigInteger("1"))));
  }
}
