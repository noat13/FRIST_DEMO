bool increaseNumberRoundness(int n) {

    string s = to_string(n);
    
    int numoz = 0;
    int numozie = 0;
    for(int i = 0; i < s.length(); i++)
    {
        if(s[i] == '0') numoz++;
    }
    
    for(int i = s.length() - 1; i >= 0; i--)
    {
        if(s[i] != '0') break;
        numozie++;
    }
    
    return numoz > numozie;
}
