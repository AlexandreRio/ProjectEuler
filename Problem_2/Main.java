public class Main {

  public static void main (String[] args) {
    int[] lastTwo = new int[2];
    int newValue = 0;
    int sum = 2;
    lastTwo[0] = 1;
    lastTwo[1] = 2;
    while (newValue <= 4000000) {
      newValue = lastTwo[0] + lastTwo[1];
      lastTwo[0] = lastTwo[1];
      lastTwo[1] = newValue;
      if (newValue%2 == 0) {
        System.out.println("Somme: " + sum + " even: " + newValue);
        sum += newValue;
      }
    }
    System.out.println(sum);
  }
}
