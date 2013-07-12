public class Main {
  private static long beginTime;

  public static void main (String[] args) {
    beginTime = System.currentTimeMillis();
    for (int i=2520;true;i++) {
      if(divisibleBy1to20(i)) {
        System.out.println(i);
        break;
      }
    }
    long finalTime = System.currentTimeMillis() - beginTime;
    System.out.println("Total time: " + finalTime + "ms.");

  }

  private static boolean divisibleBy1to20(int value) {
    for (int i=1;i<21;i++) {
      if (value%i != 0)
        return false;
    }
    return true;
  }
}
