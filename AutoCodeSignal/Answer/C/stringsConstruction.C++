int stringsConstruction(std::string a, std::string b) {
    vector<int> v1(26), v2(26);
    for(auto ch: a)
        v1[ch - 'a']++;
    for(auto ch: b)
        v2[ch - 'a']++;
    int ans = 1000;
    for(int i = 0 ; i < 26; ++i)
    {
        if(v1[i])
        {
            ans = min(v2[i] / v1[i], ans);
        }
    }
    return ans;
}
