int sumOfMultiples(int n, int k) {

    int ans = 0;
    for(int i = 1; ; i++)
    {
        if(i * k > n) break;
        ans += i * k;
    }
    
    return ans;
}
