std::string integerToStringOfFixedWidth(int number, int width) {
  int n=to_string(number).size();
   return n==width?to_string(number):n>width?to_string(number).substr(n-width):string(width-n,'0')+to_string(number);
}
