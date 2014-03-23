import java.math.BigInteger;

public class Main {

  private static final int LENGTH = 1000;

  /** First term to compute is the third one. */
  private static int term = 2;

  public static void main (String[] args) {
    BigInteger counter_one = new BigInteger("1");
    BigInteger counter_two = new BigInteger("1");

    BigInteger new_value = new BigInteger("0");
    while (!isLongEnough(new_value)) {
      term++;
      new_value = counter_two.add(counter_one);
      counter_one = counter_two;
      counter_two = new_value;
      if (term < 13)
      System.out.println("Term: " + term + " Value: " + new_value);
    }

    System.out.println("Value: " + new_value + "\nTerm: " + term);
  }

  private static boolean isLongEnough(BigInteger value) {
    if (value.toString().length() >= LENGTH )
      return true;
    else
      return false;
  }

}
