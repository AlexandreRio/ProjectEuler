public class Main {
  public static void main (String[] args) {
    for(int i=0; i<997; i++) {
      for (int j=0; j<997; j++) {
        for (int k=0; k<997; k++) {
          if ((i*i + j*j == k*k) && (i+j+k == 1000) && (i<j) && (j<k)) {
            int product = i*j*k;
            System.out.println("Product abc: " + product);
          }
        }
      }
    }
  }
}
