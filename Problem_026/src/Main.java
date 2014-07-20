import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

  private static int MAX_VALUE = 1000;
  //private static int MAX_VALUE = 10;
  private static int DECIMAL   = 2000;

  private static BigDecimal num = new BigDecimal(1);

  public static void main (String... args) {
    long startTime = System.currentTimeMillis();
    BigDecimal result;
    int longestDen = 0;
    String longestCycle = "";
    String tmp;

    for(int i=1; i<MAX_VALUE; i++) {
      BigDecimal den = new BigDecimal(i);
      try {
        result = num.divide(den);
      } catch (ArithmeticException e) {
        result = num.divide(den, DECIMAL, RoundingMode.HALF_UP);
        tmp = checkCycle(result);
        if (tmp.length() > longestCycle.length()) {
          longestDen   = i;
          longestCycle = tmp;
        }
      }
    }
    long ellapsedTime = System.currentTimeMillis() - startTime;
    System.out.println("Longest recurring cycle: " + longestCycle +
        " (" + longestCycle.length() + "characters)  for d: " + longestDen);
    System.out.println("It took: " + ellapsedTime + "ms to solve.");
  }

  /**
   * Calculate the longest recurring cycle in a big decimal number.
   *
   * @param b : Big decimal number, the integer part is not used
   *            e.g. : 0.[0-9]*
   * @return The longest recurring cycle
   */
  private static String checkCycle(BigDecimal b) {
    //BigDecimal fracBd = b.subtract(new BigDecimal(b.toBigInteger())).abs();
    //Preparing
    b = b.movePointRight(1);
    String decimal = b.toPlainString().replace(".","");

    //Local var
    String longestPattern = " ";
    String curr   = "";
    String toComp = "";
    int index     = DECIMAL-1;
    int buff_size = 0;

    while ( 2*(buff_size+1) < DECIMAL) {
      buff_size++; //increase the size of the buffer
      index = DECIMAL-1-buff_size; //go at the beginning of the string
      while ( index-buff_size >= 0) {
        curr   = decimal.substring(index, index+buff_size);
        toComp = decimal.substring(index-buff_size, index);
        //System.out.println("curr: " + curr);
        //System.out.println("toComp: " + toComp);
        if (curr.equals(toComp) && !curr.contains(longestPattern)) {
          longestPattern = curr;
        }
        index--;
      }
    }
    return longestPattern;
  }

  private static boolean isMadeOf(String pattern, String decimal) {
    for(int i=0; i<decimal.length(); i++)
      if (!pattern.equals(String.valueOf(decimal.charAt(0))))
        return false;
    return true;
  }
}
