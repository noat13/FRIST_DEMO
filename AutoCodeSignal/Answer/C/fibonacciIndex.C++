int fibonacciIndex(int n) {

    string digits;
    int i = 2;
    
    vector<int> fibseq;
    
    if(n == 1)
        return 0;
    
    fibseq.push_back(0);
    fibseq.push_back(1);
    fibseq.push_back(1);
    
    while((to_string(fibseq[i])).size() < n)
    {
        fibseq.push_back(fibseq[i] + fibseq[i-1]);
        i++;
    }
    return i;
}
