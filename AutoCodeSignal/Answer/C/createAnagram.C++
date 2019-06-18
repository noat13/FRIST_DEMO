int createAnagram(std::string s, std::string t) {

    vector<int> x(26, 0);
    for(int i = 0; i < s.length(); i++)
    {
        x[s[i] - 'A']++;
        x[t[i] - 'A']--;
    }
    
    int ans = 0;
    for(int i = 0; i < 26; i++)
    {
        ans += abs(x[i]);
    }
    return ans / 2;
}
