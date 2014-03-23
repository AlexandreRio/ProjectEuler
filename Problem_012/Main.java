public class Main {

  public static void main (String[] args) {
    int largestDivisors = 0;
    int triangleNumber  = 0;

    for (int i=1;true; i++) {
      int loop = 0;
      for (int j=1; j<=i; j++) {
        loop +=j;
      }
      triangleNumber = loop;

      if (numberOfDivisors(triangleNumber) > largestDivisors)
        largestDivisors = numberOfDivisors(triangleNumber);

      if (i%1000 == 0)
        System.out.println(i + " triangular number tested, largest number of divisors is : " + largestDivisors);

      if (largestDivisors > 500)
        break;
    }

    System.out.println("Answer: " + triangleNumber);
  }

  private static int numberOfDivisors(int value) {
    int divisors = 0;
    for (int i=1; i<=value; i++) {
      if (value%i == 0)
        divisors++;
    }
    return divisors;
  }

}
