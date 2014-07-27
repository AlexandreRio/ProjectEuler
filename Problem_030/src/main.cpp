#include <iostream>
#include <string>
#include <math.h>

unsigned int sumOfFifthPowers(unsigned int val)
{
  int result = 0;
  int digit = 0;

  while (val > 0)
  {
    digit = val%10;
    result += pow(digit, 5);
    val /= 10;
  }
  return result;
}

int main()
{
  unsigned int MAX_VALUE = 10000000;
  unsigned int sum = 0;

  for (unsigned int i=2; i<=MAX_VALUE; i++)
  {
    if (i == sumOfFifthPowers(i))
    {
      sum += i;
    }
  }
  std::cout << "Sum of all the numbers that can be written as the sum of fifth powers of their digits" << std::endl;
  std::cout << sum << std::endl;
  return 0;
}
