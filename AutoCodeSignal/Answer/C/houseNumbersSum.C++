int houseNumbersSum(std::vector<int> inputArray) {
    int ans  = 0;
    for(auto x : inputArray) {
        if (x == 0)
            break;
        else ans += x;
        
    }
    return ans;
}
