import java.util.LinkedList;
import java.util.List;

public class Main {

  private static final int MAX_VALUE = 28123;

  public static void main (String[] args) {
    long startTime = System.currentTimeMillis();
    LinkedList<Integer> cantBeWrittenAsSum = new LinkedList<Integer>();
    LinkedList<Integer> abundantNumbers    = new LinkedList<Integer>();
    int sumOfDivisors = 0;

    for (int i=1; i<MAX_VALUE; i++) {
      sumOfDivisors = sumList(getDivisors(i));
      if(sumOfDivisors > i)
        abundantNumbers.add(i);
    }

    for (int i=1; i<MAX_VALUE; i++) {
      boolean isTheSum = false;
      for(Integer a : abundantNumbers) {
        for (Integer b : abundantNumbers) {
          if (a +b == i) {
            isTheSum = true;
          } else if (a+b > i ) {
            break;
          }
        }
        if (a > i)
          break;
      }
      if (!isTheSum)
        cantBeWrittenAsSum.add(i);
    }

    int sumOfPositiveIntegers = sumList(cantBeWrittenAsSum);

    long endTime = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (endTime - startTime) + "ms.");
    System.out.println("Sum of all the positive integers which cannot be written" +
        " as the sum of two abundant numbers: "  + sumOfPositiveIntegers);
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
