int numberOfOperations(int a, int b) {

    int ans = 0;
    while(a % b == 0 || b % a == 0)
    {
        if(a % b == 0) a /= b;
        else if(b % a == 0) b /= a;
        ans++;
    }
    
    return ans;
}
