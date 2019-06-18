int differentSubstringsTrie(std::string inputString) {

    set<string> x;
    for(int i = 0; i < inputString.length(); i++)
    {
        for(int j = 1; j < inputString.length() - i + 1; j++)
        {
            x.insert(inputString.substr(i, j));
        }
    }
    
    return x.size();
}
