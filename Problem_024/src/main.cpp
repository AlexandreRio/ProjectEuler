#include <algorithm>
#include <iostream>
#include <string>

int main()
{
  std::string s = "0123456789";
  std::sort(s.begin(), s.end());
  int perm = 0;
  const int max_perm = 999999;
  while (perm < max_perm) {
    std::next_permutation(s.begin(), s.end());
    perm++;
  }
  std::cout << perm << ": " << s << std::endl;
  return 0;
}
