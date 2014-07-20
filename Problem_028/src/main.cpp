#include <iostream>
#include <string>

int main()
{
  int sum = 1;
  int current = 1;
  int square_length = 2;

  while (square_length <= 1001) {
    for (int j=0; j<4; j++) {
      //std::cout << current << " + " << square_length << std::endl;
      current += square_length;
      sum += current;
    }
    square_length += 2;
  }
  std::cout << "Sum: " << sum << std::endl ;
  return 0;
}
