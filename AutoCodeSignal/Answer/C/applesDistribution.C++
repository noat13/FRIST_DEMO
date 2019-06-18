int applesDistribution(int apples, int boxCapacity, int maxResidue) {

    int ans = 0;
    for(int i = 1; i <= apples, i <= boxCapacity; i++)
    {
        int nob = apples / i;
        int cnt = i * nob;
        int lft = apples - cnt;
        if(lft > maxResidue || lft >= i) continue;
        ans++;
    }
    return ans;
}
