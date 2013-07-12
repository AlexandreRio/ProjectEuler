public class Main {
  private static int boundary = 100;

  public static void main (String[] args) {
    int difference = squareOfSum() - sumOfSquare();
    System.out.println("Difference : "+ difference);
  }

  private static int sumOfSquare() {
    int sum = 0;
    for (int i=0; i<=boundary; i++)
      sum += i*i;
    return sum;
  }

  private static int squareOfSum() {
    int sum = 0;
    for (int i=0; i<=boundary; i++)
      sum += i;
    return sum*sum;
  }
}
