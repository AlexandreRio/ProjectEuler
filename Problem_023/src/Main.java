import java.util.LinkedList;
import java.util.List;

public class Main {

  private static final int MAX_VALUE = 28124;
  private static LinkedList<Integer> cantBeWrittenAsSum = new LinkedList<Integer>();
  private static LinkedList<Integer> abundantNumbers    = new LinkedList<Integer>();

  public static void main (String[] args) {
    long startTime = System.currentTimeMillis();
    int sumOfDivisors = 0;

    System.out.println("Compute abundant numbers.");
    for (int i=1; i<MAX_VALUE; i++) {
      sumOfDivisors = sumList(getDivisors(i));
      if(sumOfDivisors > i)
        abundantNumbers.add(i);
    }


    System.out.println("Check sum of abundant numbers.");
    for (int i=1; i<MAX_VALUE; i++) {
      if (i%(MAX_VALUE/10) == 0)
        System.out.println((i*100/MAX_VALUE)+1 + "%");
      if (!isSumOfAbundantNumbers(i))
        cantBeWrittenAsSum.add(i);
    }

    int sumOfPositiveIntegers = sumList(cantBeWrittenAsSum);

    long endTime = System.currentTimeMillis();
    System.out.println("Sum of all the positive integers which cannot be written" +
        " as the sum of two abundant numbers: "  + sumOfPositiveIntegers);
    System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
  }

  private static boolean isSumOfAbundantNumbers(int val) {
    boolean isTheSum = false;
    for(Integer a : abundantNumbers) {
      for (Integer b : abundantNumbers) {
        if (a + b == val)
          return true;
        else if (a+b > val ) {
          break;
        }
      }
      if (a > val)
        return false;
    }
    return isTheSum;
  }

  private static List<Integer> getDivisors(int value) {
    LinkedList<Integer> divisors = new LinkedList<Integer>();
    int square = (int)Math.sqrt(value);
    divisors.add(1);
    for (int i=2; i<square+1; i++) {
      if (value%i == 0) {
        divisors.add(i);
        if ( value/i != i)
          divisors.add(value/i);
      }
    }
    System.out.println("");
    return divisors;
  }

  private static int sumList(List<Integer> list) {
    int ret = 0;
    for (Integer i : list)
      ret += i;
    return ret;
  }
}
