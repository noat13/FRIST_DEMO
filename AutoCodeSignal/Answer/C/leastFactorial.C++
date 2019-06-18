int leastFactorial(int n) {

    for(int i = n; ; i++)
    {
        int pr = 1;
        for(int j = 1; ; j++)
        {
            pr *= j;
            if(pr == i) return i;
            if(pr > i) break;
        }
    }
    
}
