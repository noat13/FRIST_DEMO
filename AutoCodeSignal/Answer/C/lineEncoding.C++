std::string lineEncoding(std::string s) {
    char curr = s[0];
    int currnum = 1;
    s += ' ';
    string ans = "";
    for(int i = 1; i < s.length(); i++)
    {
        if(s[i] == curr)
        {
            currnum++;
        }
        else
        {
            if(currnum > 1)
            {
                ans += to_string(currnum);
            }
            ans += curr;
            curr = s[i];
            currnum = 1;
        }
    }
    return ans;
}
