int differentValuesInMultiplicationTable2(int n, int m) {
    set<int> x;
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= m; j++)
        {
            x.insert(i * j);
        }
    }
    return x.size();
}
