import java.util.ArrayList;

public class Main {

  public static void main (String[] args) {
    ArrayList list = new ArrayList<Integer>();
    int MAX_VALUE = 10000;
    int product;
    int sum = 0;
    String numbers;
    for (int i=0; i<MAX_VALUE; i++) {
      for (int j=0; j<MAX_VALUE; j++) {
        product = i*j;
        numbers = i + "" + j + "" + product + "";
        if(isPangidital(numbers) && !list.contains(product)) {
          list.add(product);
          sum += product;
          System.out.println(i + " × " + j + " = " + product);
        }
      }
    }
    System.out.println("sum: " + sum);
  }

  private static boolean isPangidital(String numbers) {
    if (numbers.length() != 9)
      return false;
    for (int i=1; i<10; i++)
      if (!numbers.contains("" + i))
        return false;
    return true;
  }
}
