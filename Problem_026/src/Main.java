import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

  private static int MAX_VALUE = 1000;
  private static int SCALE     = 500;

  public static void main (String... args) {
    BigDecimal num = new BigDecimal(1);
    BigDecimal result;
    int longestDen = 0;
    String longestCycle = "";
    String tmp;

    for(int i=1; i<MAX_VALUE; i++) {
      BigDecimal den = new BigDecimal(i);
      try {
        num.divide(den);
      } catch (ArithmeticException e) {
        result = num.divide(den, SCALE, RoundingMode.HALF_UP);
        System.out.println("Current: " + i);
        tmp = checkCycle(result);
        if (tmp.length() >= longestCycle.length()) {
          longestDen   = i;
          longestCycle = tmp;
        }
      }
    }
    System.out.println("Longest recurring cycle: " + longestCycle +
        " (" + longestCycle.length() + "characters)  for d: " + longestDen);
  }

  private static String checkCycle(BigDecimal b) {
    BigDecimal fracBd = b.subtract(new BigDecimal(b.toBigInteger())).abs();
    fracBd = fracBd.movePointRight(1);
    String decimal = fracBd.toPlainString().replace(".","");
    String longestPattern = " ";
    String curr   = "";
    String toComp = "";

    int index     = 0;
    int buff_size = 0;
    System.out.println(decimal);

    while ( 2*(buff_size+1) < SCALE) {
      buff_size++;
      index = 0;
      while ( index+1+ (2*buff_size) < SCALE) {
        curr   = decimal.substring(index, index+buff_size);
        toComp = decimal.substring(index+buff_size+1, index+1+2*buff_size);
        if (curr.equals(toComp) && !curr.contains(longestPattern)) {
          System.out.println("new pattern");
          longestPattern = curr;
        }
        index++;
      }
    }
    System.out.println("Loop: " + longestPattern + " (" + longestPattern.length() + ")");
    return longestPattern;
  }
}
