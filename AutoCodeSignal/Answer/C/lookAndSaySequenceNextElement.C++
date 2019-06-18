std::string lookAndSaySequenceNextElement(std::string element) {

    element += ' ';
    char curr = element[0];
    int count = 1;
    string ans = "";
    for(int i = 1; i < element.length(); i++)
    {
        if(element[i] == curr)
        {
            count++;
        }
        else
        {
            ans += to_string(count);
            ans += curr;
            curr = element[i];
            count = 1;
        }
    }
    
    return ans;
}
