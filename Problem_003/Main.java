import java.util.List;
import java.util.ArrayList;

public class Main {

  public static void main (String[] args) {
      long number = 600851475143l;
      long root = (long) Math.sqrt(number);
      double carry;
      List<Long> factor = new ArrayList<Long>();
      for (long i = 2; i<root; i++) {
        if ((number%i) == 0) {
          factor.add(new Long(i));
          System.out.println(i);
        }
      }
      for (int i=factor.size()-1; i!=0; i--) {
        if (isPrime(factor.get(i))) {
          System.out.println("Largest prime factor: " + factor.get(i));
          break;
        }
      }
  }

  private static boolean isPrime(long value) {
    long root = (long)Math.sqrt(value);
    for (int i=2; i<root; i++) {
      if( value%i == 0)
        return false;
    }
    return true;
  }

}
