int countNeighbouringPairs(std::string inputString) {
    int ans = 0;
    for(int i = 0; i < inputString.length() - 1; i++)
    {
        if(inputString[i] == inputString[i + 1]) ans++;
    }
    return ans;
}
