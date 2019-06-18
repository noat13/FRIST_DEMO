std::string longestWord(std::string text) {
    string ans = "";
    string curr = "";
    text += ' ';
    for(int i = 0; i < text.length(); i++)
    {
        if((text[i] >= 'a' && text[i] <= 'z') || (text[i] >= 'A' && text[i] <= 'Z'))
        {
            curr += text[i];
        }
        else
        {
            if(curr.length() > ans.length())
            {
                ans = curr;    
            }
            curr = "";
        }
    }
    return ans;
}

