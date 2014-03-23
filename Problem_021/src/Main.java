import java.util.LinkedList;
import java.util.List;

public class Main {

  private static final int MAX_VALUE = 10000;

  public static void main (String[] args) {
    long startTime = System.currentTimeMillis();
    LinkedList<Integer> amicableNumbers = new LinkedList<Integer>();
    int a,b = 0;

    for (int i=1; i<MAX_VALUE; i++) {
      a = sumList(getDivisors(i));
      b = sumList(getDivisors(a));
      if (i==b && a!=b && !amicableNumbers.contains(i)) {
        amicableNumbers.add(i);
        amicableNumbers.add(a);
      }
    }

    int sumOfAmicalbeNumbers = sumList(amicableNumbers);

    long endTime = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (endTime - startTime) + "ms.");
    System.out.println("Sum of all amicable numbers under " + MAX_VALUE + ": " + sumOfAmicalbeNumbers);
  }

  private static List<Integer> getDivisors(int value) {
    LinkedList<Integer> divisors = new LinkedList<Integer>();
    int square = (int)Math.sqrt(value);
    divisors.add(1);
    for (int i=2; i<square; i++)
      if (value%i == 0) {
        divisors.add(i);
        divisors.add(value/i);
      }
    return divisors;
  }

  private static int sumList(List<Integer> list) {
    int ret = 0;
    for (Integer i : list)
      ret += i;
    return ret;
  }
}
