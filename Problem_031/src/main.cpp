#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <iterator>

const int DIFFERENT_COINS = 8;
const unsigned int coins[DIFFERENT_COINS] = {1, 2, 5, 10, 20, 50, 100, 200};
//const unsigned int coins[DIFFERENT_COINS] = {200, 100, 50, 20, 10, 5, 2, 1};
const int GOAL = 200;


//std::vector<std::string> possibilities;

//void generatePossibility(int * combination, unsigned int sum)
//{
//  if (sum == GOAL) {
//    possibilities.push_back(combination);
//    std::cout << combination << std::endl;
//    return;
//  }
//
//  for (int i=0; i<DIFFERENT_COINS; i++) {
//    if (sum+coins[i] <= GOAL &&
//        std::find(std::begin(possibilities), std::end(possibilities), combination + std::to_string(coins[i])) == possibilities.end())
//      generatePossibility(combination + std::to_string(coins[i]) ,sum+coins[i]);
//  }
//}


int main()
{
  int possibilities[GOAL + 1] = {};

  possibilities[0] = 1;
  for (int i=0; i<DIFFERENT_COINS; i++) {
    for (int j=coins[i]; j<=GOAL; j++) {
      possibilities[j] += possibilities[j - coins[i]];
    }
  }
  std::cout << "Solutions trouvées: " << possibilities[GOAL] << std::endl;
  //for (std::vector<std::string>::iterator it1 = possibilities.begin(); it1 != possibilities.end(); ++it1) {
  //  std::cout << *it1 << std::endl;
  //}
  return 0;
}
