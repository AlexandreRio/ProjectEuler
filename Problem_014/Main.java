import java.math.BigInteger;

public class Main {

  public static void main (String[] args) {
    int longest = 0;
    int value   = 0;
    int tmp;

    for (int i=1; i<1000000; i++) {
      tmp = collatzSequence(i);
      if (tmp > longest) {
        longest = tmp;
        value = i;
      }
      System.out.println("Current value " + i + ", so far " + longest + " is the longest sequence.");
    }
    System.out.println("Longest sequence is " + longest + " by starting with value " + value + ".");
  }

  private static int collatzSequence(int value) {
    int length = 1;
    BigInteger curValue = new BigInteger(String.valueOf(value));
    while (curValue.intValue() != 1) {
      if (curValue.intValue()%2 == 0) {
        curValue = curValue.divide(new BigInteger("2"));
      } else {
        curValue = curValue.multiply(new BigInteger("3"));
        curValue = curValue.add(new BigInteger("1"));
      }
      length++;
    }
    return length;
  }
}
