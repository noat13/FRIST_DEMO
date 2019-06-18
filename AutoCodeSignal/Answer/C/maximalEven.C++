int maximalEven(std::vector<int> inputArray) {
    int max = 0;
    for(int i = 0; i < inputArray.size(); i++)
    {
        max = inputArray[i] % 2 ? max : inputArray[i] > max ? inputArray[i] : max;
    }
    return max;
}
