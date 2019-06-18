int arrayMaxConsecutiveSum(std::vector<int> inputArray, int k) {
    int sum =0, best;
    for(int i = 0; i < k; i++){
        sum += inputArray[i];
    }
    best = sum;
    for(int i = k; i < inputArray.size(); i++){
        sum -= inputArray[i-k];
        sum += inputArray[i];
        best = max(sum, best);
    }
    return best;
}
