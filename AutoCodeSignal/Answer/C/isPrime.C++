bool isPrime(int n) {
    for(int i(2); i * i <= n; ++i ) {
        if (n % i == 0)
            return false;
            
    }
    return true;
}

set<int> pfact(int n) {
    set<int> v;
    for(int i(2); i <= n; ++i ) {
        if (n % i == 0 && isPrime(i)) {
            v.insert(i);
            n /= i;
        }
    }
    return v;
}


std::vector<int> primeFactors2(int n) {
    set<int> s = pfact(n);
    vector<int> ans;
    for(auto x : s) {
        ans.push_back(x);
    }
    return ans;
}
