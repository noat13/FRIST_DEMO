int kStepMaximization(int n, int k) {
    if(k == 0) return n;
    int ans = n;
    ans = max(n, kStepMaximization(n + 1, k - 1));
    ans = max(ans, kStepMaximization(2 * n, k - 1));
    string s = to_string(n);
    bool can = true;
    for(int i = 0; i < s.length(); i++)
    {
        if(s[i] == '3' || s[i] == '4' || s[i] == '7')
        {
            can = false;
            break;
        }
    }
    
    if(!can) return ans;
    reverse(s.begin(), s.end());
    for(int i = 0; i < s.length(); i++)
    {
        if(s[i] == '6') s[i] = '9';
        else if(s[i] == '9') s[i] = '6';
    }
    
    int curr = stoi(s);
    ans = max(ans, kStepMaximization(curr, k - 1));
    return ans;
}
