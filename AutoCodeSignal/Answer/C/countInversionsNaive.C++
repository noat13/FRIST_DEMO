int countInversionsNaive(std::vector<int> inputArray) {
    int ans = 0;
    for(int i = 0; i < inputArray.size() - 1; i++)
    {
        for(int j = i + 1; j < inputArray.size(); j++)
        {
            if(inputArray[i] > inputArray[j])
            {
                ans++;
            }
        }
    }
    return ans;
}
