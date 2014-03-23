import java.util.List;
import java.util.ArrayList;

public class Main {

  public static void main (String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i=999; i>99; i--) {
      for (int j=999; j>99; j--) {
        if(isPalimdrome(i*j)) {
          list.add(new Integer(i*j));
          break;
        }
      }
    }
    System.out.println(list.size() + " palimdromes found.");
    System.out.println(largest(list) + " is the largest one");
  }

  private static boolean isPalimdrome(int value) {
    char[] chars = String.valueOf(value).toCharArray();
    if (chars.length%2 == 0) {
      for(int i=1; i<=chars.length/2; i++) {
        if(chars[i-1] != chars[chars.length-i])
          return false;
      }
    } else {
      for(int i=1; i<=((chars.length-1)/2); i++) {
        if(chars[i-1] != chars[chars.length-i])
          return false;
      }
    }
    return true;
  }

  private static int largest(List<Integer> list) {
    int ret = 0;
    for (int i=0; i<list.size(); i++) {
      if (list.get(i) > ret)
        ret = list.get(i);
    }
    return ret;
  }
}
