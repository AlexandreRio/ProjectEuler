#include <iostream>
#include <string>
#include <stdlib.h>
#include <math.h>

bool isPrime(double value)
{
  value = abs(value);
  if (value == 2)
    return true;
  else {
    double root = sqrt(value);
    for (double i=2; i<=root; i++)
      if (fmod(value,i) == 0)
        return false;

  }
  return true;
}

int main()
{
  int n = 0;
  int numberOfSuccesivePrime = 0;
  int longestSuccesivePrime = 0;
  int longest_a = 0;
  int longest_b = 0;

  for (int a=-999; a<1000; a++) {
    for (int b=-999; b<1000; b++) {
      numberOfSuccesivePrime = 0;
      n = 0;

      while (isPrime(n*n + a*n + b)) {
        n++;
        numberOfSuccesivePrime++;
      }

      if (numberOfSuccesivePrime > longestSuccesivePrime) {
        longestSuccesivePrime = numberOfSuccesivePrime;
        longest_a = a--;
        longest_b = b--;
      }
    }
  }

  std::cout << "Longest succession: " << longestSuccesivePrime << std::endl;
  std::cout << "a: " << longest_a << " and b: " << longest_b << " (product: " << longest_a*longest_b << " )" << std::endl;
  return 0;
}
