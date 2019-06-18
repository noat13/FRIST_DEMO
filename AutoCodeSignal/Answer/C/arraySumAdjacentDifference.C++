int arraySumAdjacentDifference(std::vector<int> inputArray) {
    int ans = 0;
    for(int i = 0; i < inputArray.size() - 1; i++)
    {
        ans += abs(inputArray[i] - inputArray[i + 1]);
    }
    return ans;
}
