std::string longestString(std::vector<std::string> inputArray) {
    struct compare {
       bool operator()(string uno, string dos) {
           return uno.size() < dos.size();
       } 
    } c;
    
    sort(inputArray.begin(), inputArray.end(), c);
    return inputArray.back();
}
