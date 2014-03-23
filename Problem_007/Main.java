public class Main {
  public static void main (String[] args) {
    long startTime = System.currentTimeMillis();
    int primeFound = 0;
    int loop  = 2;
    int lastPrime = 0;
    while (primeFound != 10001) {
      if (isPrime(loop)) {
        primeFound++;
        lastPrime = loop;
      }
      loop++;
    }
    System.out.println("10001st prime number: " + lastPrime);
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
