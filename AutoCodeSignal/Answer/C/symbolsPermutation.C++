bool symbolsPermutation(std::string word1, std::string word2) {
    vector<int> x(26, 0);
    if(word1.length() != word2.length()) return false;
    for(int i = 0; i < word1.length(); i++)
    {
        x[word1[i] - 'a']++;
        x[word2[i] - 'a']--;
    }
    
    for(int i = 0; i < 26; i++)
    {
        if(x[i])
        {
            return false;
        }
    }
        
    return true;
}
