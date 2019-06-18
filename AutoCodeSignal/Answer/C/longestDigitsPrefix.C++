std::string longestDigitsPrefix(std::string inputString) {

    string ans = "";
    inputString += 'a';
    for(int i = 0; i < inputString.length(); i++)
    {
        if(inputString[i] >= '0' && inputString[i] <= '9')
        {
            ans += inputString[i];
        }
        else
        {
            break;
        }
        
    }
    return ans;
    
}
