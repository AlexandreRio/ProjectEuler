import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

  public static void main (String[] args) {
    ArrayList<BigInteger> values = new ArrayList<BigInteger>();
    BigInteger a = new BigInteger("2");

    while (a.intValue() <= 100) {
      for (int b=2; b<= 100; b++) {
        BigInteger tmp = a.pow(b);
        if (!values.contains(tmp))
          values.add(tmp);
      }
      a = a.add(new BigInteger("1"));
    }

    System.out.println("Size: " + values.size());
  }
}
