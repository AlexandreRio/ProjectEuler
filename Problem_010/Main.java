public class Main {
  public static void main (String[] args) {
    long startTime = System.currentTimeMillis();
    long sum = 0;
    for (int i=2; i<2000000; i++) {
      if (isPrime(i))
        sum += i;
    }
    System.out.println("Sum: " + sum);
    long ellapsedTime = System.currentTimeMillis()- startTime;
    System.out.println("Total time: " + ellapsedTime + "ms.");
  }

  private static boolean isPrime(int value) {
    if (value == 2)
      return true;
    else {
      double root = Math.sqrt(value);
      for (double i=2; i<=root; i++) {
        if (value%i == 0)
          return false;
      }
    }
    return true;
  }
}
