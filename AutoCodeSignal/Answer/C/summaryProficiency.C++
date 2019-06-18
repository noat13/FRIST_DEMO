int summaryProficiency(std::vector<int> a, int n, int m) {
    long long sum = 0;
    for (int i = 0; i < a.size(); i++)
    {
        if (a[i] >= m && n > 0)
        {
            n--;
            sum+= a[i];
        }
    }
    return sum;
}
