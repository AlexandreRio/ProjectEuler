public class Bug {
  public static void main (String[] args) {
    int longest = 0;
    int value   = 0;
    int tmp;

    collatzSequence(113383);
  }

  private static int collatzSequence(int value) {
    int length = 1;
    while (value != 1) {
      System.out.println(value);
      if (value%2 == 0) {
        value /= 2;
      } else {
        value = 3*value +1;
      }
      length++;
    }
    return length;
  }
}
