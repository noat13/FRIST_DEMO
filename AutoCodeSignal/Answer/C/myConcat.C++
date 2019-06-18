std::string myConcat(std::vector<std::string> strings, std::string separator) {
        string res="";
    for(auto i:strings)
    {
        res+=i;
        res+=separator;
    }
    return res;
}
